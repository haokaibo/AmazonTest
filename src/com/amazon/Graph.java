package com.amazon;

import java.util.*;

/**
 * Created by kaibohao on 2016-11-23.
 */
public class Graph {
    public static int STEP_LENGTH = 6;
    private HashMap<Integer, Node> nodeLookup = new HashMap<>();

    public static class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<>();

        private Node(int id) {
            this.id = id;
        }
    }

    public void addNode(int id) {
        nodeLookup.put(id, new Node(id));
    }

    private Node getNode(int id) {
        return nodeLookup.get(id);
    }

    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public HashMap<Integer, Integer> countPathBFS(Node source) {
        HashMap<Integer, Integer> visitedPath = new HashMap<>();
        countPathBFS(source, visitedPath);
        return visitedPath;
    }

    private void countPathBFS(Node source, HashMap<Integer, Integer> visitedPath) {
        if (source == null || source.adjacent == null)
            return;
        LinkedList<Node> nextToVisit = new LinkedList<>();
        nextToVisit.push(source);
        int currentLevelNodes = 1;
        int nextLevelNodes = 0;
        int currentLevel = 1;
        while (!nextToVisit.isEmpty()) {
            Node current = nextToVisit.remove();
            for (Node node : current.adjacent) {
                if (visitedPath.containsKey(node.id))
                    continue;
                visitedPath.put(node.id, currentLevel);
                nextToVisit.push(node);
            }
            nextLevelNodes += current.adjacent.size();
            currentLevelNodes--;
            if (currentLevelNodes == 0) {
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
                currentLevel++;
            }
        }
    }

    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
        if (visited.contains(source)) {
            return false;
        }
        visited.add(source.id);
        if (source == destination) {
            return true;
        }
        for (Node child : source.adjacent) {
            if (hasPathDFS(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int source, int destination) {
        return hasPathBFS(getNode(source), getNode(destination));
    }

    public boolean hasPathBFS(Node source, Node destination) {
        LinkedList<Node> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if (node == destination)
                return true;
            if (visited.contains(node.id)) {
                continue;
            }
            visited.add(node.id);
            for (Node child : node.adjacent) {
                nextToVisit.add(child);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int n = in.nextInt();
            Graph g = new Graph();
            for (int j = 1; j <= n; j++) {
                g.addNode(j);
            }
            int m = in.nextInt();
            for (int k = 0; k < m; k++) {
                int source = in.nextInt();
                int destination = in.nextInt();
                g.addEdge(source, destination);
            }
            int s = in.nextInt();

            HashMap<Integer, Integer> countPaths = g.countPathBFS(g.getNode(s));
            for (int j = 1; j <= n; j++) {
                if (s == j) {
                    continue;
                }
                if (!countPaths.containsKey(j)) {
                    System.out.print("-1 ");
                } else {
                    System.out.print(String.format("%d ", countPaths.get(j) * STEP_LENGTH));
                }
            }
            System.out.println();
        }

    }
}
