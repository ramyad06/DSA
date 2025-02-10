class Solution {
    int sumbyd(int[] nums, int div){
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=Math.ceil((double)(nums[i])/(double)(div));
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        if(n>threshold) return -1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        int low=1,high=max;
        while(low<=high){
            int mid=(low+high)/2;
            if(sumbyd(nums,mid)<=threshold){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}