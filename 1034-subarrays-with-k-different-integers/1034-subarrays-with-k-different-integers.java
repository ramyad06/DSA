class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubArraysWithGoal(nums, k) - countSubArraysWithGoal(nums, k-1);
    }
    private int countSubArraysWithGoal(int[] nums, int goal){
        if(goal<=0){
            return 0;
        }
        int l=0,r=0,cnt=0,n=nums.length;
        Map<Integer,Integer> mpp = new HashMap<>();
        while(r<n){
            int numR = nums[r];
            mpp.put(numR,mpp.getOrDefault(numR,0)+1);
             while(mpp.size() > goal){
                int numL = nums[l];
                mpp.put(numL, mpp.get(numL)-1);
                if(mpp.get(numL) == 0){
                    mpp.remove(numL);
                }
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}