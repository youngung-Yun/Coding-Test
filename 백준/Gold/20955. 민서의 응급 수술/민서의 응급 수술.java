import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        List<List<Integer>> adj = initAdj(n);
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] visited = new boolean[n+1];
        int treeCount = 0;
        int disconnectCount = 0;
        // 트리 개수 - 1개만큼 트리 연결
        // 사이클 발견시 끊음
        for (int node = 1; node <= n; node++) {
            if (visited[node]) {
                continue;
            }
            ++treeCount;
            // BFS
            Queue<int[]> queue = new ArrayDeque<>();
            visited[node] = true;
            // [node, parent]
            queue.offer(new int[] {node, -1});

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                for (int next : adj.get(now[0])) {
                    if (next == now[1]) {
                        continue;
                    }
                    if (visited[next]) {
                        ++disconnectCount;
                        continue;
                    }
                    visited[next] = true;
                    queue.offer(new int[] {next, now[0]});
                }
            }
        }

        System.out.println(treeCount - 1 + (disconnectCount / 2));
    }

    private static List<List<Integer>> initAdj(int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        return adj;
    }
}