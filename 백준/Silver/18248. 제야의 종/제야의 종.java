import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] matrix = new int[n][m];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < m; c++) {
                matrix[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        System.out.println(check(matrix, n, m) ? "YES" : "NO");
    }

    static boolean check(int[][] matrix, int n, int m) {
        for (int a = 0; a < n - 1; a++) {
            for (int b = a + 1; b < n; b++) {
                int flag = 0;
                for (int c = 0; c < m; c++) {
                    if (matrix[a][c] == matrix[b][c]) {
                        continue;
                    } else {
                        if (flag == 0) {
                            flag = matrix[a][c] - matrix[b][c];
                        } else {
                            if (flag != matrix[a][c] - matrix[b][c]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}