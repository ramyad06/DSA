class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {

        long low = minProduct(nums1, nums2);  
        long high = maxProduct(nums1, nums2);   

        while (low < high) {
            long mid = low + ((high - low) >> 1);
            if (countpairs(nums1, nums2, mid) >= k) {
                high = mid;          // mid works ⇒ search lower
            } else {
                low = mid + 1;      // mid too small
            }
        }
        return low;
    }
    private long countpairs(int[] a1, int[] a2, long target) {
        long cnt = 0;
        int m = a2.length;

        for (int x : a1) {
            if (x > 0) {                             // need floor(target / x)
                long bound = Math.floorDiv(target, x);
                cnt += upperBound(a2, bound) + 1;    // elements ≤ bound
            } else if (x < 0) {                      // need ceil(target / x)
                long bound = ceilDiv(target, x);
                cnt += m - lowerBound(a2, bound);    // elements ≥ bound
            } else {                                 // x == 0
                if (target >= 0) cnt += m;
            }
        }
        return cnt;
    }
    private long ceilDiv(long a, long b) {
        return -Math.floorDiv(-a, b);
    }
    private int upperBound(int[] arr, long val) {
        int lo = 0, hi = arr.length - 1, ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] <= val) { ans = mid; lo = mid + 1; }
            else hi = mid - 1;
        }
        return ans;
    }
    private int lowerBound(int[] arr, long val) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < val) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
    private long mul(int x, int y) {          
        return (long) x * (long) y;
    }

    private long minProduct(int[] a, int[] b) {
        return Math.min(
                Math.min(mul(a[0], b[0]),mul(a[0], b[b.length - 1])),
                Math.min(mul(a[a.length - 1], b[0]),mul(a[a.length - 1], b[b.length - 1]))
        );
    }

    private long maxProduct(int[] a, int[] b) {
        return Math.max(
                Math.max(mul(a[0], b[0]),mul(a[0], b[b.length - 1])),
                Math.max(mul(a[a.length - 1], b[0]),mul(a[a.length - 1], b[b.length - 1]))
        );
    }
}
