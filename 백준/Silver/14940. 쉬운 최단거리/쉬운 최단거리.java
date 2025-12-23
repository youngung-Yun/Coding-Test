import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int dx = 0;
        int dy = 0;
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int number = Integer.parseInt(row[j]);
                map[i][j] = number;
                if (number == 2) {
                    dx = i;
                    dy = j;
                }
            }
        }
        int[][] distances = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    distances[i][j] = 0;
                } else {
                    distances[i][j] = -1;
                }
            }
        }
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] {dx, dy});
        distances[dx][dy] = 0;
        int[][] directions = new int[][] {{1, 0}, {-1, 0},  {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.removeFirst();

            for (int[] direction : directions) {
                int nx = curr[0] + direction[0];
                int ny = curr[1] + direction[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (distances[nx][ny] >= 0) {
                    continue;
                }
                queue.addLast(new int[] {nx, ny});
                distances[nx][ny] = distances[curr[0]][curr[1]] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : distances) {
            for (int col : row) {
                sb.append(col).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}