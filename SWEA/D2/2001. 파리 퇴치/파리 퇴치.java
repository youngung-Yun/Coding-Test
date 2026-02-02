import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());
            int[][] prefixSum = new int[n][n];
            for (int i = 0; i < n; i++) {
                token = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int number = Integer.parseInt(token.nextToken());
                    if (j == 0) {
                        prefixSum[i][j] = number;
                    } else {
                        prefixSum[i][j] = prefixSum[i][j-1] + number;
                    }
                }
            }
            int ans = findMaxCount(prefixSum, n, m);
            sb.append('#').append(testCase).append(' ').append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static int findMaxCount(int[][] prefix, int n, int m) {
        int max = 0;
        for (int i = 0; i < n - m + 1; i++) {
            for (int j = m - 1; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    if (j < m) {
                        sum += prefix[i+k][j];
                    } else {
                        sum += (prefix[i+k][j] - prefix[i+k][j-m]);
                    }
                }
                max = Integer.max(max, sum);
            }
        }

        return max;
    }
}