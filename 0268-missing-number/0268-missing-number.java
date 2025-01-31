class Solution {
    public int missingNumber(int[] nums) {
        int N=nums.length;
        int sum=(N*(N+1))/2;
        int s=0;
        for(int i=0;i<N;i++){
            s+=nums[i];
        }
        return (sum-s);
    }
}