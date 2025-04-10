class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack <Integer> st = new Stack<>();
        int ls[] = new int[n];
        int rs[] = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()) ls[i]=0;
            else ls[i] = st.peek()+1;
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()) rs[i]=n-1;
            else rs[i] = st.peek()-1;
            st.push(i);
        }
        int maxA=0;
        for(int i=0;i<n;i++){
            maxA = Math.max(maxA,heights[i] * (rs[i]-ls[i]+1));
        }
        return maxA;
    }
}