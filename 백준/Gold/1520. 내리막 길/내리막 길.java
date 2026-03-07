import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INIT = -1;
    final static int[] dr = {0, 0, 1, -1};
    final static int[] dc = {1, -1, 0, 0};
    static int[][] map;
    static int n;
    static int m;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new int[n][m];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        dp = new int[n][m];
        initDp();
        dp[0][0] = 1;

        int ans = getDp(n - 1, m - 1);

        System.out.println(ans);
    }

    private static int getDp(int r, int c) {
        if (dp[r][c] == INIT) {
            dp[r][c] = 0;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (!isValid(nr, nc) || map[r][c] >= map[nr][nc]) {
                    continue;
                }
                dp[r][c] += getDp(nr, nc);
            }
        }
        return dp[r][c];
    }

    private static void initDp() {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                dp[r][c] = INIT;
            }
        }
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}