import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int[][] graph = new int[n][3];
            for (int i = 0; i < n; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    int x = Integer.parseInt(row[j]);
                    graph[i][j] = x;
                }
            }
            int[][] dp = new int[n][3];
            dp[0][0] = Integer.MAX_VALUE;
            dp[0][1] = graph[0][1];
            dp[0][2] = graph[0][1] + graph[0][2];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    int min = dp[i-1][j];
                    if (j > 0) {
                        min = Integer.min(min, dp[i][j-1]);
                        min = Integer.min(min, dp[i-1][j-1]);
                    }
                    if (j + 1 < 3) {
                        min = Integer.min(min, dp[i-1][j+1]);
                    }
                    dp[i][j] = min + graph[i][j];
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(testCase).append(". ").append(dp[n-1][1]).append('\n');
            bw.write(sb.toString());
            ++testCase;
        }
        bw.flush();
        bw.close();
    }
}
