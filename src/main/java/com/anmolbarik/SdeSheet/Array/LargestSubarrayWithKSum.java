package com.anmolbarik.SdeSheet.Array;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithKSum {

    public int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int maxLen = 0;

        // Important: handles subarray starting from index 0
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Check if (prefixSum - k) exists
            if (map.containsKey(prefixSum - k)) {
                int len = i - map.get(prefixSum - k);
                maxLen = Math.max(maxLen, len);
            }

            // Store first occurrence only
            map.putIfAbsent(prefixSum, i);
        }

        return maxLen;
    }

    // Driver code
    public static void main(String[] args) {
        LargestSubarrayWithKSum obj = new LargestSubarrayWithKSum();
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2};
        int k = 3;
        System.out.println(obj.longestSubarray(arr, k)); // Output: 3
    }
}