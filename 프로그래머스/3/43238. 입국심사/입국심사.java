class Solution {
    public long solution(int n, int[] times) {
        long low = 1;
        long high = 1_000_000_000L * 1_000_000_000L;
        
        long ans = 0L;
        // mid동안 n명 이상 통과할 수 있는가?
        while (low <= high) {
            long mid = low + (high - low) / 2L;
            if (canPassImmigrationAll(mid, times, n)) {
                ans = mid;
                high = mid - 1L;
            } else {
                low = mid + 1L;
            }
        }
        
        return ans;
    }
    
    private boolean canPassImmigrationAll(long elapsed, int[] times, int n) {
        long count = 0L;
        for (int time : times) {
            count += (elapsed / time);
        }
        return count >= n;
    }
}