import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INF = 10_000 * 10_000;
    static int[][] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());

        adj = new int[n+1][n+1];
        for (int r = 0; r <= n; r++) {
            for (int c = 0; c <= n; c++) {
                if (r != c) {
                    adj[r][c] = INF;
                }
            }
        }

        for (int i = 0; i < e; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            adj[a][b] = c;
            adj[b][a] = c;
        }

        stk = new StringTokenizer(bf.readLine());
        int v1 = Integer.parseInt(stk.nextToken());
        int v2 = Integer.parseInt(stk.nextToken());

        int[] fromStart = findShortestPath(1, n);
        int[] fromV1 = findShortestPath(v1, n);
        int[] fromV2 = findShortestPath(v2, n);

        int path1 = fromStart[v1] + fromV1[v2] + fromV2[n];
        int path2 = fromStart[v2] + fromV2[v1] + fromV1[n];

        if (path1 >= INF && path2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Integer.min(path1, path2));
        }
    }

    static int[] findShortestPath(int start, int n) {
        int[] distance = new int[n+1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        // [dest, cost]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[1], a2[1]));
        pq.add(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();

            if (edge[1] > distance[edge[0]]) {
                continue;
            }

            for (int newDest = 1; newDest <= n; newDest++) {
                if (adj[edge[0]][newDest] == INF) {
                    continue;
                }
                if (distance[newDest] > edge[1] + adj[edge[0]][newDest]) {
                    distance[newDest] = edge[1] + adj[edge[0]][newDest];
                    pq.add(new int[] {newDest, distance[newDest]});
                }
            }
        }
        return distance;
    }
}