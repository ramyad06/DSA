class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) return ""; 
        int[] hashArr = new int[128];
        for (int i = 0; i < n; i++) {
            hashArr[t.charAt(i)]++;
        }

        int l = 0, r = 0;
        int ct = 0; 
        int minLen = Integer.MAX_VALUE; 
        int sIndex = -1;

        while (r < m) {
            char rightChar = s.charAt(r);
            if (hashArr[rightChar] > 0) {
                ct++;
            }
            hashArr[rightChar]--; 
            while (ct == n) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }

                char leftChar = s.charAt(l);
                hashArr[leftChar]++; 
                if (hashArr[leftChar] > 0) {
                    ct--;
                }
                l++;
            }

            r++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}