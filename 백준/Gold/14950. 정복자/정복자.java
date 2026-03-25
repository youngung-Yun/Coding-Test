import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int t = Integer.parseInt(stk.nextToken());

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            adj.get(a).add(new int[]{b, c});
            adj.get(b).add(new int[]{a, c});
        }

        boolean[] visited = new boolean[n+1];
        int total = 0;
        int conquered = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
        visited[1] = true;
        for (int[] next : adj.get(1)) {
            pq.add(next);
        }

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int dest = edge[0];
            int cost = edge[1];
            if (visited[dest]) {
                continue;
            }

            total += cost + conquered * t;
            ++conquered;
            visited[dest] = true;

            for (int[] next : adj.get(dest)) {
                pq.add(next);
            }

            if (conquered == n - 1) {
                break;
            }
        }
        System.out.println(total);
    }
}