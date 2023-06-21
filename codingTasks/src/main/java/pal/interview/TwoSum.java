package pal.interview;

import java.util.Arrays;

//https://leetcode.com/problems/two-sum/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] nums2 = nums.clone();
        Arrays.sort(nums2);
        int i = 0;
        int j = nums.length - 1;
        while (i != j) {
            if (nums2[i] + nums2[j] == target) {
                int[] r = new int[2];
                for (int k = 0; k < nums.length; k++) {
                    if (nums[k] == nums2[i]) {
                        r[0] = k;
                    }
                }
                for (int k = 0; k < nums.length; k++) {
                    if (nums[k] == nums2[j] && k != r[0]) {
                        r[1] = k;
                    }
                }

                return r;
            } else {
                if (nums2[i] + nums2[j] > target) {
                    j--;
                } else {
                    i++;
                }
            }

        }
        return new int[]{-1, -1};
    }
}
