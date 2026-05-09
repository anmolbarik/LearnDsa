package com.anmolbarik.SdeSheet.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlapInterval {

    public static int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }
        // Sort intervals based on starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Add first interval
        int[] current = intervals[0];
        merged.add(current);

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            // Overlapping intervals
            if (next[0] <= current[1]) {
                // Merge intervals
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap
                current = next;
                merged.add(current);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] result = merge(intervals);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }

}
