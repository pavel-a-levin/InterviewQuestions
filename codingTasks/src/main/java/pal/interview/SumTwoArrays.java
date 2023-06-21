package pal.interview;

import java.util.Arrays;

public class SumTwoArrays {
    public int[] twoSumArrays(int[] a, int[] b) {
        int[] res = new int[Math.max(a.length, b.length) + 1];
        int i = a.length - 1;
        int j = b.length - 1;
        int k = res.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = (i >= 0 ) ? a[i] : 0;
            int y = (j >= 0) ? b[j] : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            res[k] = sum % 10;
            i--;
            j--;
            k--;
        }
        if(res[0] == 0){
            res = Arrays.copyOfRange(res, 1, res.length);
        }
        return res;
    }
}
