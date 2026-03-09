import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // 자신보다 무겁거나 가벼운 구슬이 (n+1)/2개 이상이면 될 수 없음
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            adj.get(a).add(b);
        }

        int[] heavier = new int[n+1];
        int[] lighter = new int[n+1];

        for (int marble = 1; marble <= n; marble++) {
            boolean[] visited = new boolean[n+1];
            Queue<Integer> queue = new ArrayDeque<>();
            visited[marble] = true;
            queue.offer(marble);

            while (!queue.isEmpty()) {
                int now = queue.poll();
                if (now != marble) {
                    ++lighter[marble];
                    ++heavier[now];
                }

                for (int next : adj.get(now)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (heavier[i] >= (n + 1) / 2 || lighter[i] >= (n + 1) / 2) {
                ++ans;
            }
        }
        System.out.println(ans);
    }
}