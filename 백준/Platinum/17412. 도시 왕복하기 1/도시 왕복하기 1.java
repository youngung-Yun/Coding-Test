import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INF = -1;
    final static int START = 1;
    final static int TARGET = 2;

    static List<List<Integer>> adj = new ArrayList<>();
    static int[][] capacity;
    static int[][] flow;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int p = Integer.parseInt(stk.nextToken());

        capacity = new int[n+1][n+1];
        flow = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < p; i++) {
            stk = new StringTokenizer(bf.readLine());
            int src = Integer.parseInt(stk.nextToken());
            int dest = Integer.parseInt(stk.nextToken());
            adj.get(src).add(dest);
            capacity[src][dest] = 1;
            // 역방향 간선
            adj.get(dest).add(src);
        }

        long total = 0L;
        while (true) {
            int[] prev = new int[n+1];
            Arrays.fill(prev, INF);
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(START);

            while (!queue.isEmpty() && prev[TARGET] == INF) {
                int now = queue.poll();
                for (int next : adj.get(now)) {
                    // 간선에 용량이 남아있고 방문하지 않았음
                    if (capacity[now][next] - flow[now][next] > 0 && prev[next] == INF) {
                        prev[next] = now;
                        queue.offer(next);
                        if (next == TARGET) {
                            break;
                        }
                    }
                }
            }
            // 더 이상 도착지로 가는 경로 없음
            if (prev[TARGET] == INF) {
                break;
            }
            for (int node = TARGET; node != START; node = prev[node]) {
                ++flow[prev[node]][node];
                --flow[node][prev[node]];
            }
            ++total;
        }
        System.out.println(total);
    }
}
