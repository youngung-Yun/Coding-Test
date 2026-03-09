import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        List<List<Integer>> adj = initAdj(n);

        int[] parents = new int[n+1];
        stk = new StringTokenizer(bf.readLine());
        for (int employee = 1; employee <= n; employee++) {
            int parent = Integer.parseInt(stk.nextToken());
            if (parent != -1) {
                adj.get(parent).add(employee);
                parents[employee] = parent;
            }}

        int[] compliments = new int[n+1];
        long[] ans = new long[n+1];

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int root = Integer.parseInt(stk.nextToken());
            int amount = Integer.parseInt(stk.nextToken());
            compliments[root] += amount;
        }

        for (int employee = 1; employee <= n; employee++) {
            if (compliments[employee] > 0) {
                int amount = compliments[employee];
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(employee);
                while (!queue.isEmpty()) {
                    int now = queue.poll();
                    ans[now] += amount;
                    for (int child : adj.get(now)) {
                        if (child == parents[now]) {
                            continue;
                        }
                        queue.offer(child);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int employee = 1; employee <= n; employee++) {
            sb.append(ans[employee]).append(' ');
        }
        System.out.println(sb);
    }

    private static List<List<Integer>> initAdj(int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        return adj;
    }
}