import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        // 마지막 집 제외한 dp
        int[] withoutLastHome = new int[n+1];
        withoutLastHome[1] = money[0];
        for (int home = 2; home < n; home++) {
            withoutLastHome[home] = Integer.max(withoutLastHome[home-1], withoutLastHome[home-2] + money[home-1]);
        }
        // 첫 번째 집 제외한 dp
        int[] withoutFirstHome = new int[n+1];
        withoutFirstHome[2] = money[1];
        for (int home = 3; home <= n; home++) {
            withoutFirstHome[home] = Integer.max(withoutFirstHome[home-1], withoutFirstHome[home-2] + money[home-1]);
        }
        
        int max = 0;
        for (int i = 0; i <= n; i++) {
            max = Integer.max(max, Integer.max(withoutLastHome[i], withoutFirstHome[i]));
        }
        return max;
    }
}