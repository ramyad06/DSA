class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        int start=firstIndex(nums,target);
        int end=lastIndex(nums,target);
        int arr[]=new int[2];
        arr[0]=start;
        arr[1]=end;
        return arr;
    }

    public static int firstIndex(int[] nums,int target)
    {
        int left=0;
        int right=nums.length-1;
        int res=-1,mid;
        while(left<=right)
        {
            mid=(left+right)/2;
            if(nums[mid]==target)
            {
                res=mid;
                right=mid-1;
            }
            else if(nums[mid]>target)
            {
                right=mid-1;
            }
            else 
            {
                left=mid+1;
            }
        }
        return res;
    }
    public static int lastIndex(int[] nums,int target)
    {
        int left=0;
        int right=nums.length-1;
        int res=-1,mid;
        while(left<=right)
        {
            mid=(left+right)/2;
            if(nums[mid]==target)
            {
                res=mid;
                left=mid+1;
            }
            else if(nums[mid]>target)
            {
                right=mid-1;
            }
            else 
            {
                left=mid+1;
            }
        }
        return res;
    }
}