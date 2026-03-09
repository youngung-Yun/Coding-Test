import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int to = Integer.parseInt(stk.nextToken());
            int from = Integer.parseInt(stk.nextToken());
            adj.get(from).add(to);
        }

        int max = 0;
        List<Integer> ans = new ArrayList<>();
        for (int start = 1; start <= n; start++) {
            int result = bfs(adj, start, n);
            if (result > max) {
                max = result;
                ans.clear();
                ans.add(start);
            } else if (result == max) {
                ans.add(start);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int computer : ans) {
            sb.append(computer).append(' ');
        }
        System.out.println(sb);
    }

    private static int bfs(List<List<Integer>> adj, int start, int n) {
        int count = 0;
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            ++count;
            int now = queue.poll();

            for (int next : adj.get(now)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                queue.offer(next);
            }
        }return count;
    }
}