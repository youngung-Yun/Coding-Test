import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static double[][] p;
    static double ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            ans = 0.0;
            int n = Integer.parseInt(bf.readLine());
            p = new double[n][n];
            for (int staff = 0; staff < n; staff++) {
                StringTokenizer stk = new StringTokenizer(bf.readLine());
                for (int task = 0; task < n; task++) {
                    p[staff][task] = Double.parseDouble(stk.nextToken()) / 100.0;
                }
            }

            dfs(p, new boolean[n], 1.0, 0, n);

            System.out.printf("#%d %.6f\n", testcase, ans * 100.0);
        }
    }

    static void dfs(double[][] p, boolean[] visited, double current, int depth, int n) {
        if (depth == n) {
            ans = Double.max(ans, current);
            return;
        }

        if (ans >= current) {
            return;
        }

        for (int task = 0; task < n; task++) {
            if (visited[task]) {
                continue;
            }

            visited[task] = true;
            dfs(p, visited, current * p[depth][task], depth + 1, n);
            visited[task] = false;
        }
    }
}
