import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static long[][] zeroMatrix = {
            {0L, 0L},
            {0L, 0L}
    };
    final static long[][] baseMatrix = {
            {1L, 1L},
            {1L, 0L}
    };
    final static int MOD = 10_000;
    final static int W = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            long exp = Long.parseLong(bf.readLine());
            if (exp == -1) {
                break;
            }
            System.out.println(recursion(exp)[0][1]);
        }
    }

    private static long[][] recursion(long exp) {
        if (exp == 0L) {
            return zeroMatrix;
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
                    sum += (a[r][i] * b[i][c]);
                }
                result[r][c] = sum % MOD;
            }
        }
        return result;
    }
}