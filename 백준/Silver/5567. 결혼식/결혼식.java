import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = Integer.parseInt(bf.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // BFS
        int ans = -1;
        boolean[] visited = new boolean[n+1];
        // [number, depth]
        Queue<int[]> queue = new ArrayDeque<>();
        visited[1] = true;
        queue.offer(new int[] {1, 0});

        while (!queue.isEmpty()) {
            ++ans;
            int[] now = queue.poll();
            int number = now[0];
            int depth = now[1];
            if (depth == 2) {
                continue;
            }

            for (int next : adj.get(number)) {
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                queue.offer(new int[] {next, depth + 1});
            }
        }

        System.out.println(ans);
    }
}