import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    final static long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            List<List<int[]>> adj = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                stk = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                int c = Integer.parseInt(stk.nextToken());
                adj.get(a).add(new int[] {b, c});
                adj.get(b).add(new int[] {a, c});
            }

            long[] distance = new long[v+1];
            Arrays.fill(distance, INF);
            distance[start] = 0L;

            // [dest, cost]
            PriorityQueue<long[]> pq = new PriorityQueue<>((a1, a2) -> Long.compare(a1[1], a2[1]));
            pq.add(new long[] {start, 0L});
            while (!pq.isEmpty()) {
                long[] now = pq.poll();

                if (distance[(int) now[0]] < now[1]) {
                    continue;
                }

                for (int[] edge : adj.get((int) now[0])) {
                    if (distance[edge[0]] > now[1] + edge[1]) {
                        distance[edge[0]] = now[1] + edge[1];
                        pq.add(new long[] {edge[0], distance[edge[0]]});
                    }
                }
            }

            sb.append('#').append(testcase).append(' ')
                    .append(distance[end]).append('\n');
        }
        System.out.println(sb);
    }
}