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

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int ans = 1;
        int maxDistance = 0;
        int count = 1;

        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[1] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        // BFS
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (distance[now] > maxDistance) {
                ans = now;
                maxDistance = distance[now];
                count = 1;
            } else if (distance[now] == maxDistance) {
                ans = Integer.min(ans, now);
                ++count;
            }

            for (int next : adj.get(now)) {
                if (distance[next] != -1) {
                    continue;
                }
                distance[next] = distance[now] + 1;
                queue.offer(next);
            }
        }

        System.out.printf("%d %d %d", ans, maxDistance, count);
    }
}