class Solution {
    public static boolean possible(int[] bloomDay,int day,int m,int k){
        int cnt=0;
        int noOfB =0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                cnt++;
            }else{
                noOfB += (cnt/k);
                cnt=0;
            }
        }
        noOfB += (cnt/k);
        return noOfB >=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long val = m * 1L * k * 1L;
        if(val>bloomDay.length) return -1;
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int low=min,high=max;
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(bloomDay,mid,m,k)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}