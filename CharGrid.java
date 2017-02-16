/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package chargrid;

/**
 *
 * @author Eshan
 */
public class CharGrid {

    static char[][] grid = new char[][]{
        {'a', 'b', 'c', 'd'},
        {'c', 'x', 'c', 'b'},
        {'x', 'b', ' ', 'a'}
    };
    static char[][] plus = new char[][]{
        {' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
        {'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
        {' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
        {' ', ' ', 'p', 'y', 'y', 'y', 'y', 'y', ' '},
        {'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
        {' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '},};
    static int rowLength;
    static int colLength;

    public static int charArea(char ch) {
        rowLength = grid.length;
        colLength = grid[0].length;
        int maxRow = 0, minRow = rowLength, maxCol = 0, minCol = colLength, area = 0;
        boolean found = false;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == ch) {
                    found = true;
                    if (i > maxRow) {
                        maxRow = i;
                    }
                    if (i < minRow) {
                        minRow = i;
                    }
                    if (j > maxCol) {
                        maxCol = j;
                    }
                    if (j < minCol) {
                        minCol = j;
                    }
                }
            }
        }

        if (found == true) {
            int row = maxRow - minRow + 1;
            int column = maxCol - minCol + 1;
            area = row * column;
        }
        return area;
    }

    public static int countPlus() {
        rowLength = plus.length;
        colLength = plus[0].length;
        int plusCount = 0;
        for (int i = 2; i < rowLength - 2; i++) {
            for (int j = 2; j < colLength - 2; j++) {
                if (plus[i][j] != ' ') {
                    boolean exists = false;
                    if (plus[i][j] == plus[i][j + 1] && plus[i][j - 1] == plus[i][j]) {
                        if (plus[i][j] == plus[i + 1][j] && plus[i - 1][j] == plus[i][j]) {
                            if (plus[i][j] == plus[i][j + 2] && plus[i][j - 2] == plus[i][j]) {
                                if (plus[i][j] == plus[i + 2][j] && plus[i - 2][j] == plus[i][j]) {
                                    exists = true;
                                }
                            }
                        }
                    }
                    if (exists) {
                        plusCount++;
                    }
                }
            }
        }
        return plusCount;
    }

    public static void main(String[] args) {
        System.out.println(charArea('x'));
        System.out.println(countPlus());
    }
}
