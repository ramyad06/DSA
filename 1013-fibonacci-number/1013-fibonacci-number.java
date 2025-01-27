class Solution {
    static int fcc(int n){
        if(n<=1){
            return n;
        }
        return fcc(n-1)+fcc(n-2);
    }
    public int fib(int n) {
        return fcc(n);
    }
}