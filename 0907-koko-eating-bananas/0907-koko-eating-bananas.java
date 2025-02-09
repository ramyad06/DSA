class Solution {
    public static int findMax(int[] piles){
        int max=Integer.MIN_VALUE;
        int n=piles.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,piles[i]);
        }
        return max;
    }
    public static int TotalHours(int[] piles,int h){
        int th=0;
        int n=piles.length;
        for(int i=0;i<n;i++){
            th+=Math.ceil((double)(piles[i])/(double)(h));
        }
        return th;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=findMax(piles);
        while(low<=high){
            int mid=(low+high)/2;
            int th=TotalHours(piles,mid);
            if(th<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}