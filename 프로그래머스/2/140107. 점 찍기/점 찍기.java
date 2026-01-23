class Solution {
    public long solution(int k, int d) {
        long answer = 0L;
        
        for (int x = 0; x <= d; x += k) { 
            int y = binarySearch(x, d);
            answer += (y / k) + 1;
        }
        
        return answer;
    }
    
    // [T, T, T, T, T, F, F, F]
    // 거리가 d보다 작거나 같을 때 upper bound
    static int binarySearch(int x, int limit) {
        int low = 0;
        int high = limit + 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (decision((long) x, (long) mid, (long) limit)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low - 1;
    }
    
    static boolean decision(long x, long y, long limit) {
        return (x * x + y * y) <= limit * limit;
    }
}