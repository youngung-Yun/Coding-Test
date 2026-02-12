import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        List<Integer> primes = findPrimeNumbers(n);

        int ans = 0;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < primes.size(); right++) {
            sum += primes.get(right);
            while (left < right && sum > n) {
                sum -= primes.get(left);
                ++left;
            }
            if (sum == n) {
                ++ans;
            }
        }
        System.out.println(ans);
    }

    static List<Integer> findPrimeNumbers(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int k = i + i; k <= n; k += i) {
                    isPrime[k] = false;
                }
            }
        }
        return primes;
    }
}