import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        // 자신을 제외한 약수 중 가장 큰 수

        int length = (int) (end - begin + 1);
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            int n = (int) begin + i;
            if (n == 1) {
                answer[i] = 0;
                continue;
            }
            
            int divisor = 1;
            for (int k = 2; k * k <= n; k++) {
                if (n % k == 0) {
                    if (n / k <= 10_000_000) {
                        divisor = n / k;
                        break;
                    }
                    divisor = k;
                }
            }
            answer[i] = divisor;
        }
        
        return answer;
    }
}