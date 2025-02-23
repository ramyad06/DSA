class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int len=strs.length;
        int k=0;
        String s = strs[0];
        String t = strs[len-1];
        int minlen = Math.min(s.length(),t.length());
        for(int i=0;i<minlen;i++){
            if(s.charAt(i)==t.charAt(i)){
                k=k+1;
            }else{
                break;
            }
        }
        return s.substring(0,k);
    }
}