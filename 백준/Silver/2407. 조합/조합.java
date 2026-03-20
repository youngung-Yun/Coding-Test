import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int min = Integer.min(m, n - m);
        int max = Integer.max(m, n - m);

        BigInteger top = BigInteger.ONE;
        for (int num = max + 1; num <= n; num++) {
            top = top.multiply(new BigInteger(String.valueOf(num)));
        }
        BigInteger bottom = BigInteger.ONE;
        for (int num = 2; num <= min; num++) {
            bottom = bottom.multiply(new BigInteger(String.valueOf(num)));
        }

        System.out.println(top.divide(bottom).toString());
    }
}