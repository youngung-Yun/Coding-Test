import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        parent = IntStream.rangeClosed(0, n).toArray();
        int m = Integer.parseInt(stk.nextToken());

        // 1. MST 구함
        // 2. MST에서 가중치가 가장 큰 경로 없앰

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            edges.add(new int[] {a, b, c});
        }

        edges.sort(Comparator.comparingInt(a -> a[2]));

        int count = 0;
        int totalCost = 0;
        int maxCost = 0;
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];
            if (!union(a, b)) {
                continue;
            }

            ++count;
            totalCost += c;
            maxCost = Integer.max(maxCost, c);
            if (count == n - 1) {
                break;
            }
        }

        System.out.println(totalCost - maxCost);
    }

    private static int find (int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static boolean union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent == yParent) {
            return false;
        }

        if (xParent < yParent) {
            parent[yParent] = xParent;
        } else {
            parent[xParent] = yParent;
        }
        return true;
    }
}
