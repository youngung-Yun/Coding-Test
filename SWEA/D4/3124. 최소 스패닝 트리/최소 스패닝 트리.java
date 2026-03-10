import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());

            parent = initParent(v);

            int[][] edges = new int[e][3];

            for (int edge = 0; edge < e; edge++) {
                stk = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                int c = Integer.parseInt(stk.nextToken());

                edges[edge] = new int[] {a, b, c};
            }

            Arrays.sort(edges, Comparator.comparingInt(edge -> edge[2]));

            int count = 0;
            long totalCost = 0L;
            for (int[] edge : edges) {
                int a = edge[0];
                int b = edge[1];
                int c = edge[2];
                if (union(a, b)) {
                    totalCost += c;
                    ++count;
                }

                if (count == v - 1) {
                    break;
                }
            }

            sb.append('#').append(testcase).append(' ')
                    .append(totalCost).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static int find(int x) {
        if (parent[x] < 0) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static boolean union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return false;
        }

        if (-parent[xParent] >= -parent[yParent]) {
            parent[xParent] += parent[yParent];
            parent[yParent] = xParent;
        } else {
            parent[yParent] += parent[xParent];
            parent[xParent] = yParent;
        }

        return true;
    }

    private static int[] initParent(int v) {
        int[] parent = new int[v+1];
        Arrays.fill(parent, -1);
        return parent;
    }
}
