import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());

            int v = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());

            List<List<int[]>> adj = initAdj(v);

            for (int i = 0; i < e; i++) {
                stk = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                int c = Integer.parseInt(stk.nextToken());

                adj.get(a).add(new int[] {b, c});
                adj.get(b).add(new int[] {a, c});
            }

            boolean[] visited = new boolean[v+1];
            long totalCost = 0L;

            // [dest, cost]
            PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[1], a2[1]));
            pq.add(new int[] {1, 0});

            int count = 0;
            while (count < v) {
                int[] edge = pq.poll();
                int dest = edge[0];
                int cost = edge[1];
                if (visited[dest]) {
                    continue;
                }

                visited[dest] = true;
                ++count;
                totalCost += cost;

                for (int[] next : adj.get(dest)) {
                    pq.add(next);
                }
            }

            sb.append('#').append(tc).append(' ')
                    .append(totalCost).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static List<List<int[]>> initAdj(int v) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        return adj;
    }
}
