class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", n, n);
        return result;
    }
    private void backtrack(List<String> result, String current, int open, int close){
        if(open==0 && close==0){
            result.add(current);
            return;
        }
        if(open>0){
            backtrack(result,current+"(",open-1,close);
        }
        if(close>open)
            backtrack(result,current+")",open,close-1);
    }
}