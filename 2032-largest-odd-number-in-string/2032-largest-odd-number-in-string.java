class Solution {
    public String largestOddNumber(String num) {
        int j=-1;
        int n=num.length();
        for(int i=n-1;i>=0;i--){
            if((num.charAt(i)-'0')%2==1){
                j=i;
                break;
            }
        }
        if(j==-1) return "";
        int k=0;
        while(k<=n){
            if(num.charAt(k)!='0') break;
            k=k+1;
        }
        return num.substring(k,j+1);
    }
}