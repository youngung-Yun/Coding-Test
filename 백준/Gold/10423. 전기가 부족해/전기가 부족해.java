import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // [dest, cost]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));

        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < k; i++) {
            int city = Integer.parseInt(stk.nextToken());
            pq.add(new int[] {city, 0});
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            adj.get(a).add(new int[] {b, c});
            adj.get(b).add(new int[] {a, c});
        }

        boolean[] visited = new boolean[n+1];
        int count = 0;
        int totalCost = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int dest = now[0];
            int cost = now[1];

            if (visited[dest]) {
                continue;
            }

            ++count;
            visited[dest] = true;
            totalCost += cost;

            for (int[] next : adj.get(dest)) {
                pq.add(next);
            }

            if (count == n) {
                break;
            }
        }

        System.out.println(totalCost);
    }
}
