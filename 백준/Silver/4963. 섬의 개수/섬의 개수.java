import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                System.out.println(sb.toString());
                return;
            }

            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(row[j]);
                }
            }
            int islandCount = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        ++islandCount;
                        bfs(map, i, j);
                    }
                }
            }
            sb.append(islandCount).append('\n');
        }
    }
    private static void bfs(int[][] matrix, int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        matrix[x][y] = 0;
        queue.offerLast(new int[] {x, y});
        while (!queue.isEmpty()) {
            int[] current = queue.removeFirst();
            for (int[] direction : directions) {
                int dx = current[0] + direction[0];
                int dy = current[1] + direction[1];
                if (dx < 0 || dy < 0 | dx >= matrix.length || dy >= matrix[0].length) {
                    continue;
                }
                if (matrix[dx][dy] == 1) {
                    matrix[dx][dy] = 0;
                    queue.addLast(new int[] {dx, dy});
                }
            }
        }
    }
}
