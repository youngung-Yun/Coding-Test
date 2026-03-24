import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());
            if (m == 0) {
                break;
            }

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int[][] edges = new int[n][3];
            for (int i = 0; i < n; i++) {
                stk = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                int z = Integer.parseInt(stk.nextToken());
                edges[i] = new int[] {x, y, z};
            }
            Arrays.sort(edges, (a1, a2) -> Integer.compare(a1[2], a2[2]));

            int ans = 0;
            for (int[] edge : edges) {
                int x = edge[0];
                int y = edge[1];
                int z = edge[2];
                if (union(x, y)) {
                    continue;
                }
                ans += z;
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static int find (int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
            return false;
        }

        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
        return true;
    }
}