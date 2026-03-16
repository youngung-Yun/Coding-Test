import java.util.*;

class Solution {
    
    final static int INF = -1;
    static List<List<Integer>> adj = new ArrayList<>();
    static int[][] dp;
    
    public int solution(int n, int[][] lighthouse) {
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : lighthouse) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        // dp[i][k] : i번째 등대가 꺼졌을/켜졌을 때 최소 등대 수
        dp = new int[n+1][2];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = dp[i][1] = INF;
        }
        
        getDp(1, 1, 0);
        getDp(1, 1, 1);
        
        int ans = Integer.min(dp[1][0], dp[1][1]);
        
        return ans;
    }
    
    private static int getDp(int node, int parent, int on) {
        if (dp[node][on] != INF) {
            return dp[node][on];
        }
        // node가 꺼진 경우 자식들은 모두 켜져야 함
        if (on == 0) {
            int sum = 0;
            for (int next : adj.get(node)) {
                if (next == parent) {
                    continue;
                }
                sum += getDp(next, node, 1);
            }
            dp[node][on] = sum;
        } else {
            // node가 켜진 경우는 자식의 최솟값 합 + 1
            int sum = 1;
            for (int next : adj.get(node)) {
                if (next == parent) {
                    continue;
                }
                sum += Integer.min(getDp(next, node, 0), getDp(next, node, 1));
            }
            dp[node][on] = sum;
        }
        return dp[node][on];
    }
}