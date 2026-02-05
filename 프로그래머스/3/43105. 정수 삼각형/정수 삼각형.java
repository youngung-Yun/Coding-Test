import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle[triangle.length-1].length;
        int[][] matrix = new int[n+1][n+2];
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                matrix[i+1][j+1] = triangle[i][j];
            }
        }
        int[][] dp = new int[n+1][n+2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.max(dp[i-1][j-1], dp[i-1][j]) + matrix[i][j];
            }
        }
        int max = 0;
        for (int e : dp[n]) {
            max = Integer.max(max, e);
        }
        return max;
    }
}