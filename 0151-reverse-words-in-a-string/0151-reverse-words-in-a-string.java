class Solution {
    public String reverseWords(String s) {
        int left=0;
        int right=s.length()-1;
        while (left <= right && s.charAt(left) == ' ') left++;
        while (left <= right && s.charAt(right) == ' ') right--;
        String temp="";
        String ans="";
        while(left<=right){
            char ch = s.charAt(left);
            if(ch!=' '){
                temp+=ch;
            }else if(ch==' '){
                if(!ans.equals("")){
                    ans=temp+" "+ans;
                }else{
                    ans=temp;
                }
                temp="";
                while (left <= right && s.charAt(left) == ' ') left++;
                continue;
            }
            left++;
        }
        if(!temp.equals("")){
            if(!ans.equals("")){
                ans=temp+" "+ans;
            }else{
                ans=temp;
            }
        }
        return ans;
    }
}