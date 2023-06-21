package pal.interview;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

import static java.lang.Math.max;


public class Unsorted {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        List<Integer> s = new ArrayList<>();
        Integer[] ff = new Integer[4];
        Arrays.sort(ff, Integer::compareTo);
        Arrays.binarySearch(ff, 4);
        s.toArray(ff);
        new DecimalFormat();
        BigDecimal r = new BigDecimal(2.00000003);

        s.sort(Integer::compareTo);
        ;
        new Scanner(System.in).nextInt();
        s.toArray();
        Arrays.sort((Integer[]) s.toArray(), Integer::compareTo);
        Integer[] vv = (Integer[]) s.toArray();
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
            System.out.println(Arrays.toString(result));
        }
        System.out.println(" ");
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
            System.out.println(Arrays.toString(result));
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

// 1) Given an integer array nums, find the subarray with the largest sum, and return its sum.
//
// 2) Objective function f(x) = max(f(x-1) + x, x)
// 3) f(0) = 0
    public Integer subArrayMaxSum(int[] nums) {
        int local = nums[0];
        int global = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(local + nums[i], nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }

    /* You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
       Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

       1) Objective function
            returns maximum profit from robbing the houses
       2) Base cases
           f(0) = 0
           f(1) = 1

       3) Recurrence relation
            f(x) = max(f(x-1), f(x-2) + x)

       4) direction -- bottom up
       5) where to find the answer

       */
    public int rob(int[] nums) {
        int prev = 0;
        int global = 0;
        for (int num : nums) {
            int temp = Math.max(global, prev + num);
            prev = global;
            global = temp;
        }
        return global;
    }

    public int countPrimes(int n) {
        if (n < 1) {
            return 0;
        }
        int[] l = new int[n];
        for (int i = 2; i < n; i++) {
            l[i] = i;
        }
        int currentPrimePosition = 2;
        int op = 0;
        int currentPrime = l[currentPrimePosition];
        double limit = Math.sqrt(n);
        while (currentPrime < limit) {
            currentPrime = l[currentPrimePosition];
            if (currentPrime == 0) {
                currentPrimePosition++;
                continue;
            } else if (currentPrime > limit) {
                break;
            }
            int from = l[currentPrimePosition + 2];
            for (int i = from; i < l.length; i++) {
                int currentVal = l[i];
                if (currentVal % currentPrime == 0) {
                    l[i] = 0;
                }
            }
            currentPrimePosition++;
        }
        for (int currentVal : l) {
            if (currentVal != 0) {
                op++;
            }
        }
        return op;
    }
}
