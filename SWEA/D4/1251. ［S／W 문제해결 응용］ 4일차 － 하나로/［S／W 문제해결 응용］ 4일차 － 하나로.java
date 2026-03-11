import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            int n = Integer.parseInt(bf.readLine());

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

            List<List<Edge>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    if (a == b) {
                        continue;
                    }
                    double cost = computeCost(islandX[a], islandY[a], islandX[b], islandY[b], e);
                    adj.get(a).add(new Edge(b, cost));
                    adj.get(b).add(new Edge(a, cost));
                }
            }

            boolean[] visited = new boolean[n+1];
            int count = 0;
            PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Double.compare(e1.cost, e2.cost));
            pq.add(new Edge(0, 0.0));

            double totalCost = 0.0;
            while (count < n) {
                Edge now = pq.poll();
                if (visited[now.dest]) {
                    continue;
                }

                visited[now.dest] = true;
                ++count;
                totalCost += now.cost;

                for (Edge edge : adj.get(now.dest)) {
                    pq.add(edge);
                }
            }
            sb.append(String.format("#%d %d", testcase, Math.round(totalCost))).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static class Edge {
        public int dest;
        public double cost;

        public Edge(int dest, double cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    private static double computeCost(double ax, double ay, double bx, double by, double e) {
        double deltaX = Math.abs(ax - bx);
        double deltaY = Math.abs(ay - by);

        double distancePower = deltaX * deltaX + deltaY * deltaY;

        return e * distancePower;
    }
}
