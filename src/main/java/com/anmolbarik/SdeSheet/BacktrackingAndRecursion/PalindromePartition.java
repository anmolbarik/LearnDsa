package com.anmolbarik.SdeSheet.BacktrackingAndRecursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    public static void helper(int index, String s, List<String> current, List<List<String>> result) {

        if (index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                current.add(s.substring(index, i + 1));
                helper(index + (i - index + 1), s, current, result);
                // OR helper(i + 1, s, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = new ArrayList<>();
        helper(0, s, new ArrayList<>(), result);
        System.out.println(result);
    }
}
