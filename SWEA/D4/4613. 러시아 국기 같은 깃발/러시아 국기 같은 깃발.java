import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int testcase = 1; testcase <= t; testcase++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            // W, B, R
            int[][][] prefixSum = new int[n+1][m+1][3];
            for (int r = 1; r <= n; r++) {
                String row = bf.readLine();
                for (int c = 1; c <= m; c++) {
                    char color = row.charAt(c - 1);
                    int white = prefixSum[r][c-1][0];
                    int blue = prefixSum[r][c-1][1];
                    int red = prefixSum[r][c-1][2];
                    if (color == 'W') {
                        ++white;
                    } else if (color == 'B') {
                        ++blue;
                    } else if (color =='R') {
                        ++red;
                    }
                    prefixSum[r][c] = new int[]  { white, blue, red };
                }
            }

            int ans = n * m;
            for (int h1 = 1; h1 <= n - 2; h1++) {
                for (int h2 = h1 + 1; h2 <= n - 1; h2++) {
                    int count = 0;
                    for (int row = 1; row <= n; row++) {
                        if (row <= h1) {
                            count += m - prefixSum[row][m][0];
                        } else if (row <= h2) {
                            count += m - prefixSum[row][m][1];
                        } else {
                            count += m - prefixSum[row][m][2];
                        }
                    }
                    ans = Integer.min(ans, count);
                }
            }
            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
