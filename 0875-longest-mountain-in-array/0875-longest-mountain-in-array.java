class Solution 
{
    public int longestMountain(int[] arr) 
    {
        int n=arr.length;
        int i,max=0,j,k;
        for(i=1;i<=n-2;i++)
        {
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1])
            {
                j=i;
                int c=1;
                while(j>0 && arr[j]>arr[j-1])
                {
                    c++;
                    j--;
                }
                k=i;
                while(k<n-1 && arr[k]>arr[k+1])
                {
                    c++;
                    k++;
                }
                max=Math.max(max,c);
            }
        }
        return max;
    }
}