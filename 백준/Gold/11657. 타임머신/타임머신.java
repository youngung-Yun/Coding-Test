import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] distance = new long[n+1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[1] = 0L;
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new int[] { from, to, cost };
        }

        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int cost = edge[2];
                if (distance[from] == Long.MAX_VALUE) {
                    continue;
                }
                // 현재 to까지 가는 비용과, from 까지 간 후 해당 간선을 이용하여 to로 가는 경우의 비용을 비교
                distance[to] = Long.min(distance[to], distance[from] + cost);
            }
        }

        boolean hasCycle = false;
        // 음수 사이클 체크
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            if (distance[from] == Long.MAX_VALUE) {
                continue;
            }
            // 간선을 이용했을 때 최단거리가 갱신되면 음수 사이클이 있음
            if (distance[to] > distance[from] + cost) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(distance[i] == Long.MAX_VALUE ? -1 : distance[i]).append('\n');
        }
        System.out.println(sb);
    }
}