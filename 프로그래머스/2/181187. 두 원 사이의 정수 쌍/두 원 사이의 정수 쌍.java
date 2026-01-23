import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0L;
        for (int x = 0; x <= r2; x++) {
            long y1 = ((long) Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2))) + 1L;
            if (x > r1) {
                y1 = 0L;
            } else if (Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)) % 1.0 == 0.0) {
                y1 -= 1;
            }           
            long y2 = ((long) Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2))) + 1L;
            long dotCount = y2 - y1;
            
            if (x == 0) {
                answer += dotCount * 2L;
            } else if (y1 == 0) {
                answer += (dotCount * 4L) - 2L;
            } else {
                answer += dotCount * 4L;
            }
        }
        return answer;
    }
}