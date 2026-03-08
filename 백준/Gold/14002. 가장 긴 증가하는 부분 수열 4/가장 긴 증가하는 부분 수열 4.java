import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] seq = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] dp = new int[n];
        int[] from = new int[n];

        for (int now = 0; now < n; now++) {
            dp[now] = 1;
            from[now] = now;
            for (int prev = 0; prev < now; prev++) {
                if (seq[prev] < seq[now] && dp[prev] + 1 > dp[now]) {
                    dp[now] = Integer.max(dp[now] , dp[prev] + 1);
                    from[now] = prev;
                }
            }
        }

        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
                maxIdx = i;
            }
        }

        System.out.println(dp[maxIdx]);
        List<Integer> list = new ArrayList<>();
        int now = maxIdx;
        while (true) {
            list.add(seq[now]);
            if (now == from[now]) {
                break;
            }
            now = from[now];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(' ');
        }
        System.out.println(sb);
    }
}
