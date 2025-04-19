class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        for(int i=0;i<k;i++){
            total+=cardPoints[i];
        }
        int maxScore = total;
        for(int i=1;i<=k;i++){
            total-=cardPoints[k-i];
            total+=cardPoints[n-i];
            maxScore = Math.max(maxScore , total);
        }
        return maxScore;
    }
}