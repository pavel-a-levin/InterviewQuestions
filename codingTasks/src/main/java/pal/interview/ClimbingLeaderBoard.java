package pal.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?isFullScreen=true
public class ClimbingLeaderBoard {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> listWithoutDuplicates = ranked.stream()
                .distinct()
                .toList();
        List<Integer> res = new ArrayList<>();
        int currentRank = listWithoutDuplicates.size() + 1;
        for (Integer current : player) {
            while (currentRank > 1 && current >= listWithoutDuplicates.get(currentRank - 2)) {
                currentRank = currentRank -1;
            }
            res.add(currentRank);
        }

        return res;
    }
}
