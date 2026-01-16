import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        // [0]: 무게, [1]: 가치
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // dp[i][w] = 최대 용량이 w인 배낭에 i번째 물건까지 넣었을 때의 최대 가치
        // w + weight[i] > limit면 물건 못 넣음. dp[i][w] = dp[i-1][w]
        // w + weight[i] <= limit면 dp[i][w] = // 물건 넣을 수 있음
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            int weight = items[i - 1][0];
            int value = items[i - 1][1];

            for (int w = 1; w <= k; w++) {
                if (w < weight) { // 물건 못 넣음
                    dp[i][w] = dp[i - 1][w];
                }
                else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight] + value);
                }
            }
        }     
        
        System.out.println(dp[n][k]);
    }
}
