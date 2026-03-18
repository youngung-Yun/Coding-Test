import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INF = Integer.MAX_VALUE;
    static int n;
    static List<List<int[]>> adj;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());

            adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            stk = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int g = Integer.parseInt(stk.nextToken());
            int h = Integer.parseInt(stk.nextToken());

            for (int i = 0; i < m; i++) {
                stk = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                int c = Integer.parseInt(stk.nextToken());
                adj.get(a).add(new int[] {b, c});
                adj.get(b).add(new int[] {a, c});
            }

            int[] targets = new int[k];
            for (int i = 0; i < k; i++) {
                targets[i] = Integer.parseInt(bf.readLine());
            }

            int[] fromS = findShortestPath(start);
            int[] fromG = findShortestPath(g);
            int[] fromH = findShortestPath(h);

            List<Integer> ans = new ArrayList<>();
            for (int target : targets) {
                int distance1 = fromS[g] + fromG[h] + fromH[target];
                int distance2 = fromS[h] + fromH[g] + fromG[target];
                if (distance1 == fromS[target] || distance2 == fromS[target]) {
                    ans.add(target);
                }
            }
            ans.sort(Comparator.naturalOrder());
            for (int e : ans) {
                sb.append(e).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int[] findShortestPath(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
        // [dest, cost]
        pq.add(new int[] {start, 0});
        int[] distance = new int[n+1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        int count = 0;
        while (!pq.isEmpty()) {
            ++count;
            int[] now = pq.poll();
            int dest = now[0];
            int cost = now[1];

            if (cost > distance[dest]) {
                continue;
            }

            for (int[] next : adj.get(dest)) {
                int nextCost = distance[dest] + next[1];
                if (distance[next[0]] > nextCost) {
                    distance[next[0]] = nextCost;
                    pq.add(new int[] {next[0], nextCost});
                }
            }

            if (count == n) {
                break;
            }
        }

        return distance;
    }
}