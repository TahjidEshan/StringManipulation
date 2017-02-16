/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package tetrisgrid;

/**
 *
 * @author Eshan
 */
public class TetrisGrid {

    static boolean[][] grid = new boolean[][]{
        {true, true, true, true},
        {true, false, true, true},
        {true, true, false, true},
        {true, true, true, true},
        {true, true, true, true},
        {true, true, true, false}};
    static int row = grid.length;
    static int col = grid[0].length;

    public TetrisGrid(boolean[][] g) {
        grid = g;
    }

    /*public static void getGrid() {
     int row = grid.length;
     int col = grid[0].length;
     for (int i = row - 1; i > -1; i--) {
     for (int j = col - 1; j > -1; j--) {
     if (grid[i][j]) {
     System.out.print(grid[i][j] + " ");
     } else {
     System.out.print("     ");
     }
     }
     System.out.println();
     }
     }*/
    public static void getGrid() {
        for (int i = col - 1; i >= 0; i--) {
            for (int j = 0; j < row; j++) {
                if (grid[j][i]) {
                    System.out.print("\u25A0");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static boolean[] fullCount() {
        boolean[] full = new boolean[grid[0].length];
        for (int i = 0; i < col; i++) {
            int count = 0;
            for (int j = 0; j < row; j++) {
                if (grid[j][i]) {
                    count++;
                }
            }
            if (count == row) {
                full[i] = true;
            }
        }
        return full;
    }


    public static boolean fullCheck() {
        boolean full = false;
        for (int i = 0; i < col; i++) {
            int count = 0;
            for (int j = 0; j < row; j++) {
                if (grid[j][i]) {
                    count++;
                }
            }
            if (count == grid.length) {
                full = true;
                break;
            }
        }
        return full;
    }


    public static void clearRows() {
        //if (fullCheck()) {
        boolean[] full = fullCount();
        for (int i = 0; i < full.length - 1; i++) {
            if (full[i] && fullCheck()) {
                for (int j = 0; j < row; j++) {
                    for (int m = i; m < col - 1; m++) {
                        grid[j][m] = grid[j][m + 1];
                        grid[j][m + 1] = false;
                    }
                }
                clearRows();
            }
        }
    }
    // }


    public static void main(String[] args) {
        getGrid();
        clearRows();
        getGrid();
    }
}
