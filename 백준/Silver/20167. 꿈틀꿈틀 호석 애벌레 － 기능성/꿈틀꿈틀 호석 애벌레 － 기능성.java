import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] dp;
    static int[] food;
    static int n;
    static int k;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        food = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            food[i] = Integer.parseInt(stk.nextToken());
        }

        // i번째 먹이를 먹기 시작했을 때 만족도를 채우게 되는 인덱스
        dp = new int[n];
        Arrays.fill(dp, -1);

        for (int start = 0; start < n; start++) {
            int curr = start;
            int pleasure = 0;
            while (pleasure < k && curr < n) {
                pleasure += food[curr++];
            }
            dp[start] = --curr;
        }

        recursion(0, 0);

        System.out.println(ans);
    }

    private static void recursion(int start, int totalPleasure) {
        if (start == n) {
            ans = Integer.max(ans, totalPleasure);
            return;
        }

        for (int i = start; i < n; i++) {
            int end = dp[i];
            int pleasure = 0;
            for (int j = i; j <= end; j++) {
                pleasure += food[j];
            }
            recursion(end + 1, totalPleasure + Integer.max(pleasure - k, 0));
        }
    }
}
