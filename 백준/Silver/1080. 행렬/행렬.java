import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] original = new int[n][m];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++) {
                original[r][c] = row.charAt(c) - '0';
            }
        }

        int[][] target = new int[n][m];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++) {
                target[r][c] = row.charAt(c) - '0';
            }
        }

        int ans = 0;
        for (int r = 0; r < n - 2; r++) {
            for (int c = 0; c < m - 2; c++) {
                if (original[r][c] != target[r][c]) {
                    ++ans;
                    reverse(original, r, c);
                }
            }
        }

        if (isSame(original, target, n, m)) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }

    static void reverse(int[][] matrix, int r, int c) {
        for (int row = r; row < r + 3; row++) {
            for (int col = c; col < c + 3; col++) {
                matrix[row][col] = matrix[row][col] == 1 ? 0 : 1;
            }
        }
    }

    static boolean isSame(int[][] org, int[][] target, int n, int m) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (org[r][c] != target[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}