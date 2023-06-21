package pal.interview;

import java.util.*;

class RandomAccessShafflingArray {

    private final int[] original;
    private int[] nums;
    private final Random random = new Random();

    public RandomAccessShafflingArray(int[] nums) {
        this.original = nums.clone();
        this.nums = nums.clone();
    }

    public int[] reset() {
        nums = original.clone();
        return nums.clone();
    }

    public int[] shuffle() {
        List<Integer> l = new ArrayList<>();
        Arrays.stream(nums).forEach(l::add);
        Collections.shuffle(l);
        for (int k = 0; k < nums.length / 2; k++) {
            int i = random.nextInt(nums.length);
            swap(i, k);
        }
        return nums;
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}