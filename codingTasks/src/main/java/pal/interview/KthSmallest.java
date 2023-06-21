package pal.interview;

public class KthSmallest {
    public int kthSmallest(int[] arr, int l, int r, int k) {

        int left = l;
        int right = r;
        int res = 0;
        for (int i = 0; i <= k; i++) {
            int mid = right + left >>> 1;
            int pivot = arr[mid];
            while (left < mid && right > mid) {
                if (arr[left] > pivot && arr[right] < pivot) {
                    int tmp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = tmp;
                } else if (arr[left] > pivot) {
                    right--;
                } else if (arr[right] < pivot) {
                    left++;
                } else {
                    left++;
                    right--;
                }
            }
            res = pivot;
        }
        return res;
    }
}
