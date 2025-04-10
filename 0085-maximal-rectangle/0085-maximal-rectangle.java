class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;

        int[] heights = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxA = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) left[i] = 0;
            else left[i] = st.peek() + 1;
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) right[i] = n - 1;
            else right[i] = st.peek() - 1;
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (right[i] - left[i] + 1));
        }

        return maxA;
    }
}
