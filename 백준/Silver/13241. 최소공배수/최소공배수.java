import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        long a = Long.parseLong(tmp[0]);
        long b = Long.parseLong(tmp[1]);

        long gcd = getGCD(Math.max(a, b), Math.min(a, b));

        System.out.println(a / gcd * b);
    }

    private static long getGCD(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return getGCD(b, a % b);
        }
    }
}