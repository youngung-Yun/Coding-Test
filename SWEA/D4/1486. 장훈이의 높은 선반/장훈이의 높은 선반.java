import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int shelf;
    static int[] staffs;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(stk.nextToken());
            shelf = Integer.parseInt(stk.nextToken());
            staffs = new int[n];
            ans = 20 * 10_000;
            stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                staffs[i] = Integer.parseInt(stk.nextToken());
            }

            dfs(0, 0);
            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int depth ,int sum) {
        // 최적값 구함
        if (ans == 0) {
            return;
        }
        // shelf를 넘었을 때 계산하고 백트래킹
        if (sum >= shelf) {
            int diff = sum - shelf;
            ans = Integer.min(ans, diff);
            return;
        }
        if (depth == n) {
            return;
        }

        dfs(depth + 1, sum);
        dfs(depth + 1, sum + staffs[depth]);
    }
}
