import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = Integer.parseInt(bf.readLine());
            int[][] farm = new int[n][n];
            for (int r = 0; r < n; r++) {
                String row = bf.readLine();
                for (int c = 0; c < n; c++) {
                    farm[r][c] = row.charAt(c) - '0';
                }
            }
            int ans = bfs(farm, n);
            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static int bfs(int[][] values, int n) {
        int width = n / 2;
        // [x, y, distance]
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[] {width, width, 0});
        visited[width][width] = true;
        int totalValue = values[width][width];

        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (distance >= width) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                totalValue += values[nx][ny];
                queue.offer(new int[] {nx, ny, distance + 1});
            }
        }
        return totalValue;
    }
}
