import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String d = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean[] isPrimes = getSieve(b);
            int count = 0;
            for (int i = a; i <= b; i++) {
                if (isPrimes[i] && String.valueOf(i).contains(d)) {
                    ++count;
                }
            }
            sb.append('#').append(testCase).append(' ').append(count).append('\n');
        }
        System.out.println(sb);
    }

    static boolean[] getSieve(int n) {
        boolean[] sieve = new boolean[n+1];
        Arrays.fill(sieve, true);
        sieve[1] = false;
        for (int i = 2; i <= (int) Math.floor(Math.sqrt(n)); i++) {
            if (sieve[i]) {
                for (int k = i + i; k <= n; k += i) {
                    sieve[k] = false;
                }
            }
        }
        return sieve;
    }
}