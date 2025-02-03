class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int row=1;row<=numRows;row++){
            ans.add(generateRow(row));
        }
        return ans;
    }
    public static List<Integer> generateRow(int row){
        List<Integer> pas = new ArrayList<>();
        pas.add(1);
        long ans=1;
        for(int i=1;i<row;i++){
            ans=ans*(row-i);
            ans=ans/(i);
            pas.add((int)ans);
        }
        return pas;
    }
}