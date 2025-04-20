class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int n = nums.length;
        int l=0,r=0,jumps=0,far=0;
        while(r<=n-1){
            for(int i=l;i<=r;i++){
                far=Math.max(far,i+nums[i]);
                if(far>=n-1){
                    return jumps+1;
                }
            }
            l=r+1;
            r=far;
            jumps++;
        } 
        return jumps;
    }
}