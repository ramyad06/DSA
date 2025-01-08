class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        int i,start=0,end=0,flag=0;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                start=i;
                flag=1;
                while(nums[i]==target)
                {
                    i++;
                    if(i==nums.length)
                       break;
                }
                end=i-1;
            }
        }
        int arr[]=new int[2];
        if(flag==1){
           arr[0]=start;
           arr[1]=end;
        }
        else{
           arr[0]=-1;
           arr[1]=-1;
        }
        return arr;
    }
}
