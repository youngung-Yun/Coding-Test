import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INIT = -1;
    static int[][] dp;
    static List<List<Integer>> adj;
    static int[] population;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        population = new int[n + 1];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(stk.nextToken());
        }

        // [0] = 우수마을 X, [1] = 우수 마을
        dp = new int[n+1][2];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = INIT;
            dp[i][1] = INIT;
        }

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int ans = Integer.max(getDp(1, 1, 0), getDp(1, 1, 1));
        System.out.println(ans);
    }

    private static int getDp(int number, int parent, int idx) {
        if (dp[number][idx] != INIT) {
            return dp[number][idx];
        }
        if (idx == 0) {
            // 우수 마을이 아닌 경우
            int total = 0;
            for (int child : adj.get(number)) {
                if (child == parent) {
                    continue;
                }
                total += Integer.max(getDp(child, number, 0), getDp(child, number, 1));
            }
            dp[number][idx] = total;
            return dp[number][idx];
        } else {
            int total = 0;
            // 우수 마을로 선정된 경우 내 자식 노드는 모두 우수 마을이 아니어야 함
            for (int child : adj.get(number)) {
                if (child == parent) {
                    continue;
                }
                total += getDp(child, number, 0);
            }
            dp[number][idx] = total + population[number];
            return dp[number][idx];
        }
    }
}