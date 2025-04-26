class Solution {
    public int trailingZeroes(int n) {
        int tz = 0;
		int tzero;
		for(int i=5 ; i<=n ; i=i*5){
			tzero = n/i;   
			if(tzero != 0){
				tz= tz + tzero;
			}
			else{
				break;
			}
		}
        return tz;
    }
}