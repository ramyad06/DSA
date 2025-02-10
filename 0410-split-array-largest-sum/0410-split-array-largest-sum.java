class Solution {
    public static int countp(int[] nums,int maxsum){
        int n=nums.length;
        int p=1;
        long subsum=0;
        for(int i=0;i<n;i++){
            if(subsum+nums[i] <=maxsum){
                subsum+=nums[i];
            }else{
                p++;
                subsum = nums[i];
            }
        }
        return p;
    }
    public int splitArray(int[] nums, int k) {
        int low=nums[0];
        int high = 0;
        for(int i=0;i<nums.length;i++){
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }
        while(low<=high){
            int mid=(low+high)/2;
            int p=countp(nums,mid);
            if(p>k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}