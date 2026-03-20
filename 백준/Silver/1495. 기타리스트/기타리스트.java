import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int start = Integer.parseInt(stk.nextToken());
        int limit = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        // dp[i][k]: i번째 곡에서 볼륨 k를 만들 수 있는가?
        boolean[][] dp = new boolean[n+1][limit+1];
        dp[0][start] = true;

        for (int song = 1; song <= n; song++) {
            int volume = arr[song-1];
            for (int v = 0; v <= limit; v++) {
                if ((v - volume >= 0 && dp[song-1][v-volume]) ||
                    (v + volume <= limit && dp[song-1][v+volume])) {
                    dp[song][v] = true;
                }
            }
        }

        int ans = -1;
        for (int volume = 0; volume <= limit; volume++) {
            if (dp[n][volume]) {
                ans = volume;
            }
        }
        System.out.println(ans);
    }
}