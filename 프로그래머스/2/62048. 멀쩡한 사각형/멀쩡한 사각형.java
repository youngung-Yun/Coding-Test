class Solution {
    public long solution(int w, int h) {
        
        // y = (h/w) * x = (h * x) / w
        
        long answer = (long) w * (long) h;
        
        long x = 0L;
        long y = 0L;
        for (long i = 1L; i <= w; i++) {
            long ny = (h * i) / w;
            long diff = (ny - y) + 1L;
            if ((h * i) % w == 0L) {
                diff -= 1L;
            }
            answer -= diff;
            y = ny;
        }
        return answer;
    }
}