import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INF = 300_000 * 10;

    static int[] distance;
    // [dest, weight]
    static List<List<int[]>> adj;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int v = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());

        initAdj(v);
        distance = new int[v+1];
        Arrays.fill(distance, INF);

        int start = Integer.parseInt(bf.readLine());

        for (int edge = 0; edge < e; edge++) {
            stk = new StringTokenizer(bf.readLine());
            int src = Integer.parseInt(stk.nextToken());
            int dest = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());
            adj.get(src).add(new int[] {dest, weight});
        }

        findShortestPath(start, v);

        StringBuilder sb = new StringBuilder();
        for (int node = 1; node <= v; node++) {
            sb.append(distance[node] == INF ? "INF" : distance[node]).append('\n');
        }
        System.out.println(sb);
    }

    private static void findShortestPath(int start, int v) {
        distance[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        pq.add(new int[] {start, 0});
        int count = 0;

        while (!pq.isEmpty() && count < v) {
            int[] edge = pq.poll();
            int node = edge[0];
            int weight = edge[1];

            if (distance[node] < weight) {
                continue;
            }

            for (int[] next : adj.get(node)) {
                // 최단 경로 갱신 가능
                if (distance[next[0]] > distance[node] + next[1]) {
                    distance[next[0]] = distance[node] + next[1];
                    pq.add(new int[] {next[0], distance[next[0]]});
                }
            }
            ++count;
        }
    }

    private static void initAdj(int v) {
        adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
    }
}
