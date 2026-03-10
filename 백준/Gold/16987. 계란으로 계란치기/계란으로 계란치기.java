import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] durability;
    static int[] weight;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        durability = new int[n];
        weight = new int[n];
        ans = 0;
        for (int egg = 0; egg < n; egg++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            durability[egg] = Integer.parseInt(stk.nextToken());
            weight[egg] = Integer.parseInt(stk.nextToken());
        }

        dfs(0, 0);

        System.out.println(ans);
    }

    private static void dfs(int now, int broken) {
        ans = Integer.max(ans, broken);
        // 모든 계란 깨는 경우의 수 찾음
        if (ans == n) {
            return;
        }
        // 모든 계란 순회
        if (now == n) {
            return;
        }
        // 현재 계란 깨짐
        if (durability[now] <= 0) {
            dfs(now + 1, broken);
            return;
        }

        for (int egg = 0; egg < n; egg++) {
            if (egg == now || durability[egg] <= 0) {
                continue;
            }

            durability[egg] -= weight[now];
            durability[now] -= weight[egg];
            int brokenCount = 0;
            if (durability[egg] <= 0) {
                ++brokenCount;
            }
            if (durability[now] <= 0) {
                ++brokenCount;
            }
            dfs(now + 1, broken + brokenCount);
            durability[egg] += weight[now];
            durability[now] += weight[egg];
        }
    }
}
