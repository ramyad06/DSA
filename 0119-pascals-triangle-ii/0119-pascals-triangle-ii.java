class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList<>();
        long a=1;
        ans.add(1);
        for(int i=1;i<=rowIndex;i++){
            a=a*((rowIndex+1)-i);
            a=a/(i);
            ans.add((int)a);
        }
        return ans;
    }
}