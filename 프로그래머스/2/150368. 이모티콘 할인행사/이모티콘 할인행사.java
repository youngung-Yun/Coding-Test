import java.util.*;

class Solution {
    
    static int[] discountRate = {10, 20, 30, 40};
    
    static int maxSubscriber = 0;
    static int maxSales = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        // 백트래킹으로 모든 할인율 계산
        bfs(users, emoticons, new int[emoticons.length], 0, emoticons.length);
        return new int[] {maxSubscriber, maxSales};
    }
    
    private void bfs(int[][] users, int[] emoticons, int[] rates, int depth, int n) {
        if (depth == n) {
            computePurchase(users, emoticons, rates, n);
            return;
        }
        
        for (int discount : discountRate) {
            rates[depth] = discount;
            bfs(users, emoticons, rates, depth + 1, n);
        }
    }
    
    private void computePurchase(int[][] users, int[] emoticons, int[] rates, int n) {
        int subscriber = 0;
        int sales = 0;
        for (int[] user : users) {
            int preferredRate = user[0];
            int limitCost = user[1];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                // 원하는 할인율보다 높으면 구입
                int price = emoticons[i];
                int rate = rates[i];
                if (rate >= preferredRate) {
                    sum += (price / 100) * (100 - rate);
                }
            }
            // 구매 비용이 제한 이상이면 서비스 가입 
            if (sum >= limitCost) {
                subscriber += 1;
            } else {
                sales += sum;
            }
        }
        
        if (maxSubscriber < subscriber ||
            (maxSubscriber == subscriber && maxSales < sales)) {
            maxSubscriber = subscriber;
            maxSales = sales;
        }
    }
}