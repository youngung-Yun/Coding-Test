import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = Integer.parseInt(reader.readLine());
            double[] posX = new double[n];
            double[] posY = new double[n];
            StringTokenizer token = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                double x = Double.parseDouble(token.nextToken());
                posX[i] = x;
            }
            token = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                double y = Double.parseDouble(token.nextToken());
                posY[i] = y;
            }
            double tax = Double.parseDouble(reader.readLine());

            int[] parent = IntStream.rangeClosed(0, n).toArray();

            Edge[] edges = new Edge[n*n-n];
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (i == k) {
                        continue;
                    }
                    // 비용 계산
                    double deltaX = Math.abs(posX[i] - posX[k]);
                    double deltaY = Math.abs(posY[i] - posY[k]);
                    double distancePow = (deltaX * deltaX) + (deltaY * deltaY);
                    double cost = distancePow * tax;
                    edges[index] = new Edge(i, k, cost);
                    index += 1;
                }
            }
            Arrays.sort(edges, (e1,e2) -> Double.compare(e1.cost, e2.cost));

            double answer = 0.0;
            int count = 0;
            for (Edge edge : edges) {
                int a = edge.start;
                int b = edge.end;
                double c= edge.cost;

                if (find(parent, a) == find(parent, b)) {
                    continue;
                }
                union(parent, a, b);
                answer += c;
                count += 1;

                if (count == n - 1) {
                    break;
                }
            }
            builder.append('#').append(testCase).append(' ').append(Math.round(answer)).append('\n');
        }
        System.out.println(builder);
    }

    static class Edge {
        public int start;
        public int end;
        public double cost;

        public Edge(int start, int end, double cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static int find(int[] parent, int x) {
        if (x != parent[x]) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    static void union(int[] parent, int x, int y) {
        int parentX = find(parent, x);
        int parentY = find(parent, y);

        parent[parentX] = parentY;
    }
}

