class Solution {
    public long solution(int[] diffs, int[] times, long limit) {
        // 숙련도가 [F, F, F, ... , F, T, T, T] 일 때 첫 번째 T의 값 구하기
        // 조건이 T인 Lower Bound
        long low = 1;
        long high = 1_000_000_000_000_000L + 1L;
        while (low < high) {
            long mid = low + (high - low) / 2L;
            if (decision(diffs, times, limit, mid)) {
                high = mid;
            } else {
                low = mid + 1L;
            }
        }
        
        return low;
    }
    
    // Math.min(diff - level, 0) * (time_cur + time_prev) + time_cur
    private boolean decision(int[] diffs, int[] times, long limit, long level) {
        long duration = times[0];
        for (int i = 1; i < times.length; i++) {
            duration += (Math.max(diffs[i] - level, 0L) * (times[i] + times[i-1])) + times[i];
        }
        return duration <= limit;
    }
}