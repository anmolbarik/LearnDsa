package com.anmolbarik.SdeSheet.stackAndQueue;

import java.util.Stack;

public class largestRectangleinHistogram {
    // in stack we store index.
    //then we traverse when we get any smaller height that current stack top element.
    // we calculate area at that point.
    // because if smaller height came we can't expand rectangle height more than smallest element.

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];

                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();

                int width = right - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
