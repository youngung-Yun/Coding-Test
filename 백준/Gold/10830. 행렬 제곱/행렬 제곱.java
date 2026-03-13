import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int MOD = 1_000;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(stk.nextToken());
        long exponent = Long.parseLong(stk.nextToken());

        long[][] matrix = new long[n][n];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                matrix[r][c] = Long.parseLong(stk.nextToken());
            }
        }

        long[][] result = multiplyMatrix(matrix, exponent);

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                sb.append(result[r][c] % MOD).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static long[][] multiplyMatrix(long[][] matrix, long exp) {
        if (exp == 1L) {
            return matrix;
        }

        long[][] halfExp = multiplyMatrix(matrix, exp / 2L);
        long[][] result = multiplyMatrix(halfExp, halfExp);
        if (exp % 2L == 0) {
            return result;
        } else {
            return multiplyMatrix(result, matrix);
        }
    }

    private static long[][] multiplyMatrix(long[][] a, long[][] b) {
        long[][] result = new long[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                long sum = 0L;
                for (int i = 0; i < n; i++) {
                    sum += (a[r][i] * b[i][c]);
                }
                sum %= MOD;
                result[r][c] = sum;
            }
        }
        return result;
    }
}