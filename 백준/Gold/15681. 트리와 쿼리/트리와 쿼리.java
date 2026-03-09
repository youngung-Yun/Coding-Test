import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[] nodeCount;
    static List<List<Integer>> adj;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int root = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());

        nodeCount = new int[n+1];
        adj = initAdj(n);

        for (int edge = 0; edge < n - 1; edge++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        findNodeCount(root, root);

        for (int i = 0; i < q; i++) {
            int query = Integer.parseInt(bf.readLine());
            System.out.println(nodeCount[query]);
        }
    }

    private static List<List<Integer>> initAdj(int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        return adj;
    }

    private static void findNodeCount(int root, int parent) {
        int count = 1;
        for (int next : adj.get(root)) {
            if (next == parent) {
                continue;
            }
            findNodeCount(next, root);
            count += nodeCount[next];
        }

        nodeCount[root] = count;
    }
}