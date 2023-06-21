package pal.interview;

import java.util.List;

public class FindUniqueElement {

    public int findUnique(List<Integer> l) {
        return l.stream().reduce((acc, it) -> acc ^ it).orElse(0);

    }

    // assuming array is sorted. This way we can do this in O(log(n)) complexity
    public int findUniqueInSorted(List<Integer> l) {
        if (l.size() == 0) {
            return -1;
        } else if (l.size() == 1) {
            return l.get(0);
        }
        int left = 0;
        int right = l.size() - 1;
        while (left <= right) {
            int mid = right + left >>> 1;
            if (mid == 0 || mid == l.size() - 1) {
                return l.get(mid);
            }
            Integer leftNeighbour = l.get(mid - 1);
            Integer middleValue = l.get(mid);
            Integer rightNeighbour = l.get(mid + 1);
            if (leftNeighbour < middleValue && middleValue < rightNeighbour) {
                return middleValue;
            } else if (middleValue.equals(rightNeighbour) && (mid + 1) % 2 == 1) {
                left = mid + 1;
            } else if (middleValue.equals(leftNeighbour) && mid % 2 == 1) {
                left = mid + 1;
            } else if (middleValue.equals(rightNeighbour) && (mid + 1) % 2 == 0) {
                right = mid - 1;
            } else if (middleValue.equals(leftNeighbour) && mid % 2 == 0) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
