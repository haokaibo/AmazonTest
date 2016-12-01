package com.amazon;

import java.util.*;

/**
 * Created by kaibohao on 2016-12-1.
 */
public class ConnectedCellInGrid {
    public class Graph {
        HashSet<String> nodes = new HashSet<>();

        public void addNode(String nodeId) {
            if (!nodes.contains(nodeId)) {
                nodes.add(nodeId);
            }
        }

        public int getRegion() {
            return nodes.size();
        }
    }

    private List<ConnectedCellInGrid.Graph> graphs = new ArrayList<>();
    private HashMap<String, Graph> nodes = new HashMap<>();

    public int getMaxRegion(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] visited = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (visited[row][col] == 1)
                    continue;
                visited[row][col] = 1;
                if (grid[row][col] == 1) {
                    String nodeId = String.format("%d_%d", row, col);
                    Graph g = new Graph();
                    g.addNode(nodeId);
                    graphs.add(g);
                    nodes.put(nodeId, g);
                    getNodeAdjacents(grid, row, col, g, visited);
                }// end of if (grid[row][col] == 1) {
            }
        }
        int maxRegion = 0;
        for (Graph g : graphs) {
            if (g.getRegion() > maxRegion) {
                maxRegion = g.getRegion();
            }
        }
        return maxRegion;
    }

    private void getNodeAdjacents(int[][] grid, int row, int col, Graph currentGraph, int[][] visited) {
        String nodeId;
        for (int i = Math.max(0, row - 1); i <= Math.min(row + 1, grid.length - 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(col + 1, grid[row].length - 1); j++) {
                if (visited[i][j] == 1) {
                    continue;
                }
                visited[i][j] = 1;
                if (grid[i][j] == 1) {
                    nodeId = String.format("%d_%d", i, j);
                    currentGraph.addNode(nodeId);
                    getNodeAdjacents(grid, i, j, currentGraph, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            for (int grid_j = 0; grid_j < m; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        ConnectedCellInGrid connectedCellInGrid = new ConnectedCellInGrid();
        int maxRegion = connectedCellInGrid.getMaxRegion(grid);
        System.out.println(maxRegion);
    }
}
