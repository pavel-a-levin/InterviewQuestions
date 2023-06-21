package pal.interview;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-words/
public class MostFrequentWord {
    public List<String> mostFrequent(String s, int k) {
        String[] l = s.split(" ");
        Map<String, Integer> m = new HashMap<>();
        for (String value : l) {
            if (m.containsKey(value)) {
                m.put(value, m.getOrDefault(value, 1) + 1);
            } else {
                m.put(value, 1);
            }
        }
        Comparator<Map.Entry<String, Integer>> comp = (e1, e2) -> {
            if (e2.getValue() == null) {
                return 1;
            }
            if (e1.getValue() == null) {
                return -1;
            }
            if (e1.getValue() > e2.getValue()) {
                return 1;
            } else if (e1.getValue() < e2.getValue()) {
                return -1;
            } else {
                return e2.getKey().compareTo(e1.getKey());
            }
        };

        Queue<Map.Entry<String, Integer>> q = new PriorityQueue<>(comp);
        q.addAll(m.entrySet());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(q.poll().getKey());
        }

        return res;

    }

}
