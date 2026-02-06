import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    final static int MAX = 125 * 125 * 100;
    final static int[] dx = {0, 0, 1, -1};
    final static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = 1;
        while (true) {
            int n = Integer.parseInt(bf.readLine());
            if (n == 0) {
                break;
            }
            int[][] cave = new int[n][n];
            for (int r = 0; r < n; r++) {
                StringTokenizer token = new StringTokenizer(bf.readLine());
                for (int c = 0; c < n; c++) {
                    cave[r][c] = Integer.parseInt(token.nextToken());
                }
            }

            int[][] cost = new int[n][n];
            for (int[] row : cost) {
                Arrays.fill(row, MAX);
            }
            // [cost, destX, destY]
            PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[0], a2[0]));
            pq.add(new int[] {cave[0][0], 0, 0});
            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                if (current[0] > cost[current[1]][current[2]]) {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = current[1] + dx[i];
                    int ny = current[2] + dy[i];
                    if (!isValid(nx, ny, n)) {
                        continue;
                    }
                    // 현재 구한 (nx, ny)로 가는 비용보다 (x, y)까지 가는 경로
                    // + (x, y)에서 (nx, ny) 가는 경로가 더 싸면 갱신
                    if (cost[nx][ny] > current[0] + cave[nx][ny]) {
                        cost[nx][ny] = current[0] + cave[nx][ny];
                        pq.add(new int[] {cost[nx][ny], nx, ny});
                    }
                }
            }
            int ans = cost[n-1][n-1];
            sb.append("Problem ").append(testCase).append(": ").append(ans).append('\n');
            ++testCase;
        }
        System.out.println(sb);
    }

    static boolean isValid(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

}