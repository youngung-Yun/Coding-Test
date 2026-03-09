import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int root = 0;
        int[] parents = new int[n];
        for (int node = 0; node < n; node++) {
            int parent = Integer.parseInt(stk.nextToken());
            parents[node] = parent;
            if (parent == -1) {
                root = node;
            } else {
                adj.get(parent).add(node);
            }
        }
        int remove = Integer.parseInt(bf.readLine());

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(root);
        int leafNodeCount = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == remove) {
                continue;
            }

            boolean isLeatNode = true;

            for (int next : adj.get(current)) {
                if (next == parents[current]) {
                    continue;
                }
                if (next == remove) {
                    continue;
                }
                isLeatNode = false;
                queue.offer(next);
            }

            if (isLeatNode) {
                ++leafNodeCount;
            }
        }

        System.out.println(leafNodeCount);
    }
}