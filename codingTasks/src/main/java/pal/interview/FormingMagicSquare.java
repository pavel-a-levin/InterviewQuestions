package pal.interview;

import java.util.List;

// https://www.hackerrank.com/challenges/magic-square-forming/problem?isFullScreen=true
public class FormingMagicSquare {
    public static int formingMagicSquare(List<List<Integer>> s) {
        int[][] magicSquares = new int[][]{
                {6, 1, 8, 7, 5, 3, 2, 9, 4},
                {8, 1, 6, 3, 5, 7, 4, 9, 2},
                {6, 7, 2, 1, 5, 9, 8, 3, 4},
                {8, 3, 4, 1, 5, 9, 6, 7, 2},
                {2, 7, 6, 9, 5, 1, 4, 3, 8},
                {4, 3, 8, 9, 5, 1, 2, 7, 6},
                {2, 9, 4, 7, 5, 3, 6, 1, 8},
                {4, 9, 2, 3, 5, 7, 8, 1, 6}
        };

        int[] minRes = new int[8];
        for(int i = 0; i < magicSquares.length; i++){
            int min = 0;
            int j = 0;
            for(List<Integer> s1 : s){
                for(Integer v: s1){
                    min += Math.abs(magicSquares[i][j] - v);
                    j++;
                }
            }
            minRes[i] = min;
        }
        int res = 999999999;
        for (int minRe : minRes) {
            if (minRe < res) {
                res = minRe;
            }
        }
        return res;
    }
}
