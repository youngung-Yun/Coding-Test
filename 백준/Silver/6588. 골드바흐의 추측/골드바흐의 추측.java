import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeSet<Integer> primes = getPrimes();

        while (true) {
            int n = Integer.parseInt(bf.readLine());
            if (n == 0) {
                break;
            }

            for (int prime : primes) {
                int b = n - prime;
                if (primes.contains(b)) {
                    sb.append(n).append(" = ").append(prime).append(" + ").append(b).append('\n');
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    static TreeSet<Integer> getPrimes() {
        TreeSet<Integer> primes = new TreeSet<>();
        boolean[] isPrime = new boolean[1_000_001];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= 1_000_000; i++) {
            if (!isPrime[i]) {
                continue;
            }
            if (i % 2 == 1) {
                primes.add(i);
            }
            for (int m = i + i; m <= 1_000_000; m += i) {
                isPrime[m] = false;
            }
        }
        return primes;
    }
}