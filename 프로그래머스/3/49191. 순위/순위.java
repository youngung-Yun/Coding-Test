import java.util.*;

class Solution {
    final static int INF = 101;
    public int solution(int n, int[][] results) {
        
        int[][] adj = new int[n+1][n+1];
        for (int[] row : adj) {
            Arrays.fill(row, INF);
        }
        
        for (int player = 1; player <= n; player++) {
            adj[player][player] = 0;
        }
        for (int[] result : results) {
            adj[result[0]][result[1]] = 1;
        }
        
        for (int through = 1; through <= n; through++) {
            for (int from = 1; from <= n; from++) {
                for (int to = 1; to <= n; to++) {
                    adj[from][to] = Integer.min(adj[from][to], adj[from][through] + adj[through][to]);
                }
            }
        }
        
        int ans = 0;
        for (int player = 1; player <= n; player++) {
            if (knowGrade(adj, player, n)) {
                ++ans;
            }
        }
        return ans;
    }
    
    private boolean knowGrade(int[][] adj, int player, int n) {
        for (int other = 1; other <= n; other++) {
            if (player == other) {
                continue;
            }
            if (adj[player][other] == INF && adj[other][player] == INF) {
                return false;
            }
        }
        return true;
    }
}