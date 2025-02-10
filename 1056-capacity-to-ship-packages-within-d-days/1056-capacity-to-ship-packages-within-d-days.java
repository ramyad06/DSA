class Solution {
    int finddays(int[] weights,int cap){
        int days=1;
        int load=0;
        int n=weights.length;
        for(int i=0;i<n;i++){
            if(load+weights[i]>cap){
                days+=1;
                load=weights[i];
            }else{
                load+=weights[i];
            }
        }
        return days;
    }
    int maximum(int[] weights){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++){
            max=Math.max(max,weights[i]);
        }
        return max;
    }
    int sum(int[] weights){
        int sum=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
        }
        return sum;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = maximum(weights),high=sum(weights);
        while(low<=high){
            int mid=(low+high)/2;
            int nodays=finddays(weights,mid);
            if(nodays<=days){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}