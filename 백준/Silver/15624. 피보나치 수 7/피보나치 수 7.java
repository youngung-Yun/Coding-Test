import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    final static long MOD = 1_000_000_007;

    final static long[][] identityMatrix = {
            {0L, 0L},
            {0L, 0L}
    };
    final static long[][] baseMatrix = {
            {1L, 1L},
            {1L, 0L}
    };
    final static int W = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long exp = Long.parseLong(bf.readLine());
        System.out.println(recursion(exp)[0][1] % MOD);
    }

    private static long[][] recursion(long exp) {
        if (exp == 0L) {
            return identityMatrix;
        } else if (exp == 1L) {
            return baseMatrix;
        }

        long halfExp = exp / 2L;
        long[][] halfPower = recursion(halfExp);
        long[][] result = multiplyMatrix(halfPower, halfPower);
        if (exp % 2 == 0) {
            return result;
        } else {
            return multiplyMatrix(result, baseMatrix);
        }
    }

    private static long[][] multiplyMatrix(long[][] a, long[][] b) {
        long[][] result = new long[W][W];
        for (int r = 0; r < W; r++) {
            for (int c = 0; c < W; c++) {
                long sum = 0;
                for (int i = 0; i < W; i++) {
                    sum = (sum + (a[r][i] * b[i][c]) % MOD) % MOD;
                }
                result[r][c] = sum;
            }
        }
        return result;
    }
}