import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    final static int MAX = 1_001;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int[][] adj = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int connected = Integer.parseInt(stk.nextToken());
                    if (r == c) {
                        adj[r][c] = 0;
                    } else {
                        adj[r][c] = connected == 1 ? connected : MAX;
                    }
                }
            }

            for (int pass = 0; pass < n; pass++) {
                for (int src = 0; src < n; src++) {
                    for (int dest = 0; dest < n; dest++) {
                        adj[src][dest] = Integer.min(adj[src][dest], adj[src][pass] + adj[pass][dest]);
                    }
                }
            }

            int ans = MAX * MAX;
            for (int src = 0; src < n; src++) {
                int cc = 0;
                for (int dest = 0; dest < n; dest++) {
                    cc += adj[src][dest];
                }
                ans = Integer.min(ans, cc);
            }
            sb.append('#').append(tc).append(' ')
                    .append(ans).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}