class Solution {
    public void solve(int col,List<String> board,List<List<String>> ans,List<Integer> leftRow,List<Integer> upperDiag,List<Integer> lowerDiag,int n){
        if(col==n){
            ans.add(new ArrayList<>(board));  
            return;
        }
        for(int row=0;row<n;row++){
            if(leftRow.get(row)==0 && lowerDiag.get(row+col)==0 && upperDiag.get(n-1+col-row)==0){
                char[] charArray = board.get(row).toCharArray();
                charArray[col] = 'Q';
                board.set(row, new String(charArray));
                leftRow.set(row, 1);
                lowerDiag.set(row + col, 1);
                upperDiag.set(n - 1 + col - row, 1);
                solve(col + 1, board, ans, leftRow, upperDiag, lowerDiag, n);
                charArray[col] = '.';
                board.set(row, new String(charArray));
                leftRow.set(row, 0);
                lowerDiag.set(row + col, 0);
                upperDiag.set(n - 1 + col - row, 0);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> ans=new ArrayList<>();
       List<String> board=new ArrayList<>(n);
       String s = ".".repeat(n);       
       for(int i=0;i<n;i++){
         board.add(s);
       }
        List<Integer> leftRow = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> upperDiag = new ArrayList<>(Collections.nCopies(2 * n - 1, 0));
        List<Integer> lowerDiag = new ArrayList<>(Collections.nCopies(2 * n - 1, 0));
        solve(0,board,ans,leftRow,upperDiag,lowerDiag,n);
        return ans;   
    }
}