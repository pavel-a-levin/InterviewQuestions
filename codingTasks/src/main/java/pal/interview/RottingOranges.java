package pal.interview;

import java.util.Arrays;

//https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        int[][] prevGrid = grid;
        int[][] newGrid = new int[grid.length][grid[0].length];
        int minutes = 0;

        while (!Arrays.deepEquals(newGrid, prevGrid)) {
            if (minutes > 0) {
                int[][] tmp = newGrid.clone();
                newGrid = prevGrid.clone();
                prevGrid = tmp;
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (prevGrid[i][j] == 0) {
                        newGrid[i][j] = 0;
                    } else if (prevGrid[i][j] == 2) {
                        newGrid[i][j] = 2;
                    } else if (
                            i - 1 >= 0 && prevGrid[i - 1][j] == 2
                                    || i + 1 < grid.length && prevGrid[i + 1][j] == 2
                                    || j - 1 >= 0 && prevGrid[i][j - 1] == 2
                                    || j + 1 < grid[0].length && prevGrid[i][j + 1] == 2
                    ) {
                        newGrid[i][j] = 2;
                    } else {
                        newGrid[i][j] = 1;
                    }
                }
            }

            minutes++;
        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (prevGrid[i][j] != 2 && prevGrid[i][j] != 0) {
                    return -1;
                }
            }
        }

        return minutes;
    }

}
