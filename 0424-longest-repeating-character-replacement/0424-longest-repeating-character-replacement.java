class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,maxlen=0,maxf=0;
        Map<Character,Integer> mpp = new HashMap<>();
        while(r<s.length()){
            char ch = s.charAt(r);
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
            maxf=Math.max(maxf,mpp.get(ch));
            if((r-l+1)-maxf>k){
                char ch2 = s.charAt(l);
                mpp.put(ch2,mpp.get(ch2)-1);
                l++;
            }
            if((r-l+1)-maxf<=k){
                maxlen=Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}