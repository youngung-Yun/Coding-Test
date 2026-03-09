import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        while (true) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            if (a == -1) {
                break;
            }
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int minPoint = n;
        List<Integer> candidates = new ArrayList<>();
        for (int start = 1; start <= n; start++) {
            int point = bfs(adj, start, n);
            if (point < minPoint) {
                minPoint = point;
                candidates.clear();
                candidates.add(start);
            } else if (point == minPoint) {
                candidates.add(start);
            }
        }

        sb.append(minPoint).append(' ').append(candidates.size()).append('\n');
        for (int candidate : candidates) {
            sb.append(candidate).append(' ');
        }
        System.out.println(sb);
    }


    private static int bfs(List<List<Integer>> adj, int start, int n) {
        int maxDistance = 0;
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            maxDistance = now[1];

            for (int next : adj.get(now[0])) {
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                queue.offer(new int[] {next, now[1] + 1});
            }
        }
        return maxDistance;
    }
}