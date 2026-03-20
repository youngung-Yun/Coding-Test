import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] square = new int[n][m];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++)
                square[r][c] = row.charAt(c) - '0';
        }

        int ans = 1;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int curr = square[r][c];

                int rightR = r;
                int rightC = c + 1;
                int downR = r + 1;
                int downC = c;
                int rightDownR = r + 1;
                int rightDownC = c + 1;

                while (isValid(rightR, rightC, n, m) && isValid(downR, downC, n, m) && isValid(rightDownR, rightDownC, n, m)) {
                    if (curr == square[rightR][rightC] && curr == square[downR][downC] && curr == square[rightDownR][rightDownC]) {
                        int width = rightC - c + 1;
                        ans = Integer.max(ans, width * width);
                    }
                    ++rightC;
                    ++downR;
                    ++rightDownR;
                    ++rightDownC;
                }
            }
        }

        System.out.println(ans);
    }

    static boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}