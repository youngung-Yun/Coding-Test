import javax.naming.PartialResultException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int NONE = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(bf.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(bf.readLine());
            // int[a][k] : 노드 a의 2^k번째 부모
            int[][] parent = initParent(n);
            List<List<Integer>> children = new ArrayList<>();
            for (int node = 0; node <= n; node++) {
                children.add(new ArrayList<>());
            }

            for (int edge = 0; edge < n - 1; edge++) {
                StringTokenizer stk = new StringTokenizer(bf.readLine());
                int p = Integer.parseInt(stk.nextToken());
                int c = Integer.parseInt(stk.nextToken());
                parent[c][0] = p;
                children.get(p).add(c);
            }

            fillParent(parent, n);
            int root = findRoot(parent, n);

            int[] depth = computeDepth(children, n, root);

            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            int lca = findLowestCommonAncestor(parent, depth, a, b);
            sb.append(lca).append('\n');
        }
        System.out.println(sb);
    }

    private static int findLowestCommonAncestor(int[][] parent, int[] depth, int a, int b) {
        // 1. 노드간 깊이를 맞춤
        int diff = Math.abs(depth[b] - depth[a]);
        for (int shift = 0; shift < 15; shift++) {
            if ((diff & (0b1 << shift)) != 0) {
                if (depth[a] > depth[b]) {
                    a = parent[a][shift];
                } else {
                    b = parent[b][shift];
                }
            }
        }

        while (a != b) {
            int ancestor = 0;
            while (parent[a][ancestor] != NONE && parent[b][ancestor] != NONE && parent[a][ancestor] != parent[b][ancestor]) {
                ++ancestor;
            }
            if (ancestor > 0) {
                --ancestor;
            }
            a = parent[a][ancestor];
            b = parent[b][ancestor];
        }

        return a;
    }

    private static int[][] initParent(int n) {
        int[][] parent = new int[n+1][15];
        for (int[] outer : parent) {
            Arrays.fill(outer, NONE);
        }
        return parent;
    }

    private static void fillParent(int[][] parent, int n) {
        for (int exp = 1; exp < 15; exp++) {
            for (int node = 1; node <= n; node++) {
                // 나의 2^k번째 부모 = 나의 2^(k-1)번째 부모의 2^(k-1)번째 부모
                int ancestor = parent[node][exp-1];
                if (ancestor != NONE) {
                    parent[node][exp] = parent[ancestor][exp-1];
                }
            }
        }
    }

    private static int findRoot(int[][] parent, int n) {
        int[] depth = new int[n+1];
        int root = 0;
        for (int node = 1; node <= n; node++) {
            if (parent[node][0] == NONE) {
                root = node;
                break;
            }
        }
        return root;
    }

    private static int[] computeDepth(List<List<Integer>> children, int n, int root) {
        int[] depth = new int[n+1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {root, 1});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            depth[now[0]] = now[1];

            for (int child : children.get(now[0])) {
                queue.offer(new int[] {child, now[1] + 1});
            }
        }
        return depth;
    }
}

