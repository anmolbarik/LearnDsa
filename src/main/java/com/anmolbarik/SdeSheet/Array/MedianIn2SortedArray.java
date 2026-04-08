package com.anmolbarik.SdeSheet.Array;

//BINARY SEARCH IN TWO SORTED ARRAY.

public class MedianIn2SortedArray {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) return findMedianSortedArrays(B, A);

        int n = A.length;
        int m = B.length;
        int low = 0, high = n;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n + m + 1) / 2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : A[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : B[cut2 - 1];
            int r1 = (cut1 == n) ? Integer.MAX_VALUE : A[cut1];
            int r2 = (cut2 == m) ? Integer.MAX_VALUE : B[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}
