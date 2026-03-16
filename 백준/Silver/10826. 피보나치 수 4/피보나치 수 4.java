import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    final static BigInteger[][] identityMatrix = {
            {BigInteger.ONE, BigInteger.ZERO},
            {BigInteger.ZERO, BigInteger.ONE}
    };
    final static BigInteger[][] baseMatrix = {
            {BigInteger.ONE, BigInteger.ONE},
            {BigInteger.ONE, BigInteger.ZERO}
    };
    final static int W = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long exp = Long.parseLong(bf.readLine());
        System.out.println(recursion(exp)[0][1]);
    }

    private static BigInteger[][] recursion(long exp) {
        if (exp == 0L) {
            return identityMatrix;
        } else if (exp == 1L) {
            return baseMatrix;
        }

        long halfExp = exp / 2L;
        BigInteger[][] halfPower = recursion(halfExp);
        BigInteger[][] result = multiplyMatrix(halfPower, halfPower);
        if (exp % 2 == 0) {
            return result;
        } else {
            return multiplyMatrix(result, baseMatrix);
        }
    }

    private static BigInteger[][] multiplyMatrix(BigInteger[][] a, BigInteger[][] b) {
        BigInteger[][] result = new BigInteger[W][W];
        for (int r = 0; r < W; r++) {
            for (int c = 0; c < W; c++) {
                BigInteger sum = BigInteger.ZERO;
                for (int i = 0; i < W; i++) {
                    sum = sum.add(a[r][i].multiply(b[i][c]));
                }
                result[r][c] = sum;
            }
        }
        return result;
    }
}