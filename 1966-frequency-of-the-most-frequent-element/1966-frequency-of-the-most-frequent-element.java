import java.util.Arrays;
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long total=0;
        int left=0;
        int max=0;
        for(int right=0;right<nums.length;right++){
            total+=nums[right];
            while((long)(right-left+1)*nums[right]-total>k){
                total-=nums[left];
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}