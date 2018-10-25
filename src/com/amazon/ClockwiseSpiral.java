package com.amazon;

public class ClockwiseSpiral {

    int index = 0;

    void printMatrixWithClockwiseSpiral(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int iteration = 1;
        int row = 0;
        int column = 0;
        int begin = 0;
        int end = m - 1;
        int total = m * n;

        while (index < total) {
            if(!leftToRight(matrix, row, begin, end, total))
                break;
            column = end;
            begin = row + 1;
            end = n - iteration;

            if(!topToBottom(matrix, column, begin, end, total))
                break;
            row = end;
            begin = column - 1;
            end = iteration - 1;

            if(!rightToLeft(matrix, row, begin, end, total))
                break;
            column = end;
            begin = row - 1;
            end = iteration;

            if(!bottomToTop(matrix, column, begin, end, total))
                break;
            iteration++;
            row = end;
            begin = column + 1;
            end = m - iteration;
        }
    }

    boolean leftToRight(int[][] matrix, int row, int begin, int end, int total) {
        if (row > matrix.length - 1) {
            return false;
        }
        for (int i = begin; i <= end; i++) {
            System.out.printf("%d\n", matrix[row][i]);
            index++;
            if (index > total) {
                return false;
            }
        }
        return true;
    }

    boolean topToBottom(int[][] matrix, int column, int begin, int end, int total) {
        if (column > matrix[0].length - 1 || column < 0) {
            return false;
        }
        for (int i = begin; i <= end; i++) {
            System.out.printf("%d\n", matrix[i][column]);
            index++;
            if (index > total) {
                return false;
            }
        }
        return true;
    }

    boolean rightToLeft(int[][] matrix, int row, int begin, int end, int total) {
        if (row > matrix.length - 1) {
            return false;
        }
        for (int i = begin; i >= end; i--) {
            System.out.printf("%d\n", matrix[row][i]);
            index++;
            if (index > total) {
                return false;
            }
        }
        return true;
    }

    boolean bottomToTop(int[][] matrix, int column, int begin, int end, int total) {
        if (column > matrix[0].length - 1 || column < 0) {
            return false;
        }
        for (int i = begin; i >= end; i--) {
            System.out.printf("%d\n", matrix[i][column]);
            index++;
            if (index > total) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 4;
        int[][] matrix = new int[n][m];
        int index = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = index;
                System.out.printf("%d ", index);
                index++;
            }
            System.out.println();
        }
        System.out.println("---------------");
        ClockwiseSpiral clockwiseSpiral = new ClockwiseSpiral();
        clockwiseSpiral.printMatrixWithClockwiseSpiral(matrix);
    }
}
