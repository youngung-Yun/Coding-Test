import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        // [dest, cost]
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));

        for (int dest = 0; dest < n; dest++) {
            int cost = Integer.parseInt(bf.readLine());
            pq.add(new int[] {dest, cost});
        }

        List<List<int[]>> adj = new ArrayList<>();
        for (int node = 0; node < n; node++) {
            adj.add(new ArrayList<>());
        }

        for (int src = 0; src < n; src++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int dest = 0; dest < n; dest++) {
                int cost = Integer.parseInt(stk.nextToken());
                if (src == dest) {
                    continue;
                }
                adj.get(src).add(new int[] {dest, cost});
            }
        }

        boolean[] visited = new boolean[n];
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
            totalCost += cost;
            visited[dest] = true;

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
