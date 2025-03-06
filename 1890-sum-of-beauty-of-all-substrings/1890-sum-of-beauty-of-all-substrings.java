class Solution {
    public int beautySum(String s) {
        int n=s.length();
        int total=0;
        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                total+=getbeauty(freq);
            }
        }
        return total;
    }
    private int getbeauty(int[] freq){
        int maxfreq=0,minfreq=Integer.MAX_VALUE;
        for(int f : freq){
            if(f>0){
                maxfreq=Math.max(maxfreq,f);
                minfreq=Math.min(minfreq,f);
            }
        }
        return maxfreq-minfreq;
    }
}