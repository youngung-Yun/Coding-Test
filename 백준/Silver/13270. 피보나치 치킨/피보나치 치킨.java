import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1);
        fibonacci.add(2);
        while (fibonacci.get(fibonacci.size() - 1) < n) {
            fibonacci.add(fibonacci.get(fibonacci.size() - 1) + fibonacci.get(fibonacci.size() - 2));
        }

        // n인분 시켰을 때의 최소/최대 치킨 수
        long[] minDp = new long[n+1];
        long[] maxDp = new long[n+1];
        Arrays.fill(minDp, 100_000_000L);
        for (int i = 1; i  < fibonacci.size(); i++) {
            if (fibonacci.get(i) > n) {
                break;
            }
            minDp[fibonacci.get(i)] = fibonacci.get(i - 1);
            maxDp[fibonacci.get(i)] = fibonacci.get(i - 1);
        }

        for (int people = 2; people <= n; people++) {
            for (int i = 2; i <= people; i++) {
                long minAmount = minDp[i] + minDp[people - i];
                long maxAmount = maxDp[i] + maxDp[people - i];

                minDp[people] = Long.min(minDp[people], minAmount);
                maxDp[people] = Long.max(maxDp[people], maxAmount);
            }
        }

        System.out.println(minDp[n] + " " + maxDp[n]);
    }
}
