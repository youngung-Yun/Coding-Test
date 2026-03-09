import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = 0;
        while (true) {
            ++testcase;
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                stk = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                adj.get(a).add(b);
                adj.get(b).add(a);
            }

            int[] parent = new int[n+1];
            int treeCount = 0;
            for (int root = 1; root <= n; root++) {
                if (parent[root] == 0 && isTree(adj, parent, n, root)) {
                    ++treeCount;
                }
            }
            sb.append("Case ").append(testcase).append(": ");
            if (treeCount > 1) {
                sb.append("A forest of ").append(treeCount).append(" trees.").append('\n');
            } else if (treeCount == 1) {
                sb.append("There is one tree.").append('\n');
            } else {
                sb.append("No trees.").append('\n');
            }
        }
        System.out.println(sb);
    }

    private static boolean isTree(List<List<Integer>> adj, int[] parent, int n, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        parent[start] = start;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : adj.get(now)) {
                if (next == parent[now]) {
                    continue;
                }

                if (parent[next] != 0) {
                    return false;
                }

                parent[next] = now;
                queue.offer(next);
            }
        }

        return true;
    }
}