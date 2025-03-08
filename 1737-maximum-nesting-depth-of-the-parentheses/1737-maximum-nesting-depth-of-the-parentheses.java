class Solution {
    public int maxDepth(String s) {
        int depth=0,maxdepth=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ') return 0;
            if(s.charAt(i)=='(') depth++;
            if(s.charAt(i)==')') depth--;
            maxdepth=Math.max(maxdepth,depth);
        }
        return maxdepth;
    }
}