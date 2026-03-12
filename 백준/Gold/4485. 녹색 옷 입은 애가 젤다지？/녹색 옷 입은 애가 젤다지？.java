import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    final static int INF = 125 * 125 * 10;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int tc = 0;
        while (true) {
            ++tc;
            int n = Integer.parseInt(bf.readLine());
            if (n == 0) {
                break;
            }

            int[][] cave = new int[n][n];
            for (int r = 0; r < n; r++) {
                StringTokenizer stk = new StringTokenizer(bf.readLine());
                for (int c = 0; c < n; c++) {
                    cave[r][c] = Integer.parseInt(stk.nextToken());
                }
            }

            int[][] distance = new int[n][n];
            for (int[] row : distance) {
                Arrays.fill(row, INF);
            }

            findShortestPath(cave, distance, n);
            sb.append("Problem ").append(tc).append(": ")
                    .append(distance[n-1][n-1]).append('\n');
        }
        System.out.println(sb);
    }

    private static void findShortestPath(int[][] weight, int[][] distance, int n) {
        // [r, c, w]
        distance[0][0] = weight[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[2]));
        pq.add(new int[] {0, 0, weight[0][0]});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int r = now[0];
            int c = now[1];
            int w = now[2];

            if (distance[r][c] < w) {
                continue;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (!isValid(nr, nc, n)) {
                    continue;
                }
                if (distance[nr][nc] > distance[r][c] + weight[nr][nc]) {
                    distance[nr][nc] = distance[r][c] + weight[nr][nc];
                    pq.add(new int[] {nr, nc, distance[nr][nc]});
                }
            }
        }
    }

    private static boolean isValid(int r, int c, int n) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}
