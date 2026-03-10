import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            int n = Integer.parseInt(bf.readLine());

            parent = initParent(n);

            double[] islandX = new double[n];
            double[] islandY = new double[n];

            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                islandX[i] = Double.parseDouble(stk.nextToken());
            }

            stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                islandY[i] = Double.parseDouble(stk.nextToken());
            }

            double e = Double.parseDouble(bf.readLine());


            List<Edge> edges = new ArrayList<>();
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    if (a == b) {
                        continue;
                    }
                    double cost = computeCost(islandX[a], islandY[a], islandX[b], islandY[b], e);

                    edges.add(new Edge(a, b, cost));
                }
            }
            edges.sort(Comparator.comparingDouble(e2 -> e2.cost));

            int count = 0;
            double totalCost = 0.0;
            for (Edge edge : edges) {
                if (!union(edge.a, edge.b)) {
                    continue;
                }

                ++count;
                totalCost += edge.cost;

                if (count == n - 1) {
                    break;
                }
            }

            sb.append('#').append(testcase).append(' ')
                    .append(Math.round(totalCost)).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static class Edge {
        public int a;
        public int b;
        public double cost;

        public Edge(int a, int b, double cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    private static int[] initParent(int n) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        return parent;
    }

    private static double computeCost(double ax, double ay, double bx, double by, double e) {
        double deltaX = Math.abs(ax - bx);
        double deltaY = Math.abs(ay - by);

        double distancePower = deltaX * deltaX + deltaY * deltaY;

        return e * distancePower;
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

        if (parent[xParent] < parent[yParent]) {
            parent[xParent] += parent[yParent];
            parent[yParent] = xParent;
        } else {
            parent[yParent] += parent[xParent];
            parent[xParent] = yParent;
        }
        return true;
    }
}
