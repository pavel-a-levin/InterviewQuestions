package pal.interview;

// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
// 1) You are climbing a staircase. It takes n steps to reach the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
// 2) Objective function f(x) = f(x-1) + f(x-2)
// 3) f(0) = 1, f(1) = 1, f(2) = 2
// 4) test:
    /*      --
     *     --
     *   --
     * --
     * f(4) = 5
     * */
    public Integer stairCaseProblem(int n) {
        int a = 1;
        int b = 1;
        int res = 0;
        for (int i = 2; i < n + 1; i++) {
            res = a + b;
            a = b;
            b = res;

        }
        return res;
    }
}
