import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        // 첫 번째 집 터는 경우(마지막 집은 털 수 없음)
        int[] dp1 = new int[n];
        dp1[0] = money[0];
        dp1[1] = Integer.max(money[0], money[1]);
        for (int home = 2; home < n - 1; home++) {
            dp1[home] = Integer.max(dp1[home-1], dp1[home-2] + money[home]);
        }
        
        
        // 첫 번째 집 안터는 경우 (마지막 집을 털 수 있음)
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = money[1];
        for (int home = 2; home < n; home++) {
            dp2[home] = Integer.max(dp2[home-1], dp2[home-2] + money[home]);
        }
        
        int ans = Integer.max(dp1[n-2], dp2[n-1]);
        return ans;
    }
}