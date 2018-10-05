package com.dropbox;

import com.sun.javaws.exceptions.InvalidArgumentException;
import sun.plugin.dom.exception.InvalidStateException;

public class ConwayGame {
    class Cell {
        int x;
        int y;
        char value;

        Cell(int x, int y, char value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    Cell[][] cells = null;
    Cell current = null;
    int steps = 0;
    int size = 0;

    public ConwayGame(int size, int steps) throws InvalidArgumentException {
        if (size == 0)
            throw new InvalidArgumentException(new String[]{String.valueOf(size)});
        this.size = size;
        this.cells = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (Math.random() > 0.5)
                    this.cells[i][j] = new Cell(i, j, '.');
                else
                    this.cells[i][j] = new Cell(i, j, '*');
            }
        }
        this.current = cells[0][0];
        this.steps = steps;
    }

    public void printCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.printf("%c ", cells[i][j]);
            }
            System.out.println();
        }
    }

    public boolean moveUp() {
        if (current == null)
            throw new InvalidStateException("The game is not initialized properly. Please restart the game.");
        if (current.y == 0)
            throw new InvalidStateException("The current position is on the top row of the matrix, " +
                    "which cannot be moved up.");
        if (cells[current.x][current.y - 1].value == '*')
            throw new InvalidStateException("The up position is dead, which cannot be moved to.");

        current.y -= 1;

        changeNeighboursState(current);
        this.steps--;

        if (current.x == this.size - 1 && current.y == this.size - 1) {
            return true;
        } else {
            if (steps == 0)
                throw new InvalidStateException("The steps used up, the game is over.");
            return false;
        }
    }

    private void changeNeighboursState(Cell current) {
        // from left top to right bottom
        if (current.x - 1 >= 0 && current.y - 1 >= 0) {
            Cell target = cells[current.x - 1][current.y - 1];
            if (isAlive(target)) {
                target.value = '.';
            } else {
                target.value = '*';
            }
        }
    }

    private boolean isAlive(Cell target) {
        int left = Math.max(target.x - 1, 0);
        int right = Math.min(target.x + 1, size - 1);
        int top = Math.max(target.y - 1, 0);
        int bottom = Math.min(target.y + 1, size - 1);
        int sumOfLives = 0;

        for (int i = left; i <= right; i++) {
            for (int j = top; j <= bottom; j++) {
                if (i == target.x && j == target.y) {
                    continue;
                }
                if (cells[i][j].value == '.') {
                    sumOfLives++;
                }
            }
        }

        if (target.value == '.') {
            if (sumOfLives < 2 || sumOfLives > 3) {
                return false;
            } else if (sumOfLives >= 2 && sumOfLives <= 3) {
                return true;
            }
        } else {
            if (sumOfLives == 3) {
                return true;
            }
        }
        return false;
    }
}
