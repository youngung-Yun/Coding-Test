import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            int[] parent = new int[v+1];
            List<List<Integer>> children = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                children.add(new ArrayList<>());
            }

            stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < e; i++) {
                int p = Integer.parseInt(stk.nextToken());
                int c = Integer.parseInt(stk.nextToken());
                parent[c] = p;
                children.get(p).add(c);
            }

            int root = findRoot(parent, v);
            int[] depth = computeDepth(children, root, v);

            // 깊이 맞춤
            while (depth[a] > depth[b]) {
                a = parent[a];
            }
            while (depth[a] < depth[b]) {
                b = parent[b];
            }

            while (a != b) {
                a = parent[a];
                b = parent[b];
            }
            int lca = a;
            int size = getSubtreeSize(children, lca);

            sb.append('#').append(tc).append(' ')
                    .append(lca).append(' ').append(size).append('\n');
        }
        System.out.println(sb);
    }

    private static int findRoot(int[] parent, int n) {
        int root = 0;
        for (int node = 1; node <= n; node++) {
            if (parent[node] == 0) {
                root = node;
                break;
            }
        }
        return root;
    }

    private static int[] computeDepth(List<List<Integer>> children, int root, int n) {
        int[] depth = new int[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int child : children.get(now)) {
                queue.offer(child);
                depth[child] = depth[now] + 1;
            }
        }
        return depth;
    }

    private static int getSubtreeSize(List<List<Integer>> children, int root) {
        int size = 1;
        for (int child : children.get(root)) {
            size += getSubtreeSize(children, child);
        }

        return size;
    }
}
