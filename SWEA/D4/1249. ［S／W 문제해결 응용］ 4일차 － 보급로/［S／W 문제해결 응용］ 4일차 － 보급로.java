import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        final int INF = 100 * 100 * 10 + 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                String row = br.readLine();
                for (int k = 0; k < n; k++) {
                    map[i][k] = Character.getNumericValue(row.charAt(k));
                }
            }

            int[][] distance = new int[n][n];
            for (int[] row : distance) {
                Arrays.fill(row, INF);
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.cost, n2.cost));
            distance[0][0] = 0;
            pq.add(new Node(0, 0, 0));

            while (!pq.isEmpty()) {
                Node current = pq.poll();

                for (int[] dir : dirs) {
                    int nx = current.x + dir[0];
                    int ny = current.y + dir[1];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        continue;
                    }
                    if (distance[current.x][current.y] + current.cost < distance[nx][ny]) {
                        distance[nx][ny] = distance[current.x][current.y] + current.cost;
                        pq.add(new Node(nx, ny, map[nx][ny]));
                    }
                }
            }

            sb.append('#').append(testCase).append(' ').append(distance[n-1][n-1]).append('\n');
        }
        System.out.println(sb);
    }

    static class Node {
        public int x;
        public int y;
        public int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}