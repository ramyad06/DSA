class Solution {
    static boolean palindrome(int i,String s,int n){
        if(i>=n/2)
           return true;
        if(s.charAt(i)!=s.charAt(n-i-1)) 
           return false;
        return palindrome(i+1,s,n);
    }
    public boolean isPalindrome(String s) {
        String t=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int n=t.length();
        if(t.isEmpty()){
            return true;
        }else{
            return palindrome(0,t,n);
        }
    }
}