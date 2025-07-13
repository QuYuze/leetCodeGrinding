package Playground;

import java.util.Stack;

//https://leetcode.com/problems/largest-rectangle-in-histogram/solutions/6757248/using-stack-beginner-friendly-explanation-c-java-python3-javascript/

public class LargestRectangleInHistogram {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> st = new Stack<>();
            int length = heights.length;
            int area = 0;

            for (int i = 0; i < length; i++) {
                // Process stack while current bar is smaller than top of stack
                while (!st.empty() && heights[i] < heights[st.peek()]) {
                    int bar = st.pop(); // Index of the bar
                    int pse = st.empty() ? -1 : st.peek(); // Previous smaller element index
                    int nse = i; // Current index is next smaller element
                    // Width = nse - pse - 1
                    area = Math.max(area, heights[bar] * (nse - pse - 1));
                    System.out.println(area);
                }
                st.push(i);
            }

            // Process remaining bars in stack
            while (!st.empty()) {
                int bar = st.pop();
                int pse = st.empty() ? -1 : st.peek();
                int nse = length;
                area = Math.max(area, heights[bar] * (nse - pse - 1));

            }

            return area;
        }
    }
}
