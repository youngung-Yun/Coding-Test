import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int row;
    static int col;
    static int checkpointRow;
    static int checkpointCol;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        row = Integer.parseInt(stk.nextToken());
        col = Integer.parseInt(stk.nextToken());
        int checkpoint = Integer.parseInt(stk.nextToken());
        checkpointRow = (checkpoint - 1) / col;
        checkpointCol = (checkpoint - 1) % col;

        int ans = 0;
        if (checkpoint == 0) {
            ans = getPathCount(0, 0, row - 1, col - 1);
        } else {
            ans = getPathCount(0, 0, checkpointRow, checkpointCol) * getPathCount(checkpointRow, checkpointCol, row - 1, col - 1);
        }
        System.out.println(ans);
    }

    static int getPathCount(int sr, int sc, int er, int ec) {
        int[][] dp = new int[row][col];
        for (int r = sr; r <= er; r++) {
            for (int c = sc; c <= ec; c++) {
                if (r == sr || c == sc) {
                    dp[r][c] = 1;
                    continue;
                }
                dp[r][c] = dp[r-1][c] + dp[r][c-1];
            }
        }
        return dp[er][ec];
    }
}