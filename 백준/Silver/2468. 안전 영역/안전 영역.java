import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] areas = new int[n][n];
        int maxHeight = 0;
        for (int row = 0; row < n; ++row) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                int x = Integer.parseInt(st.nextToken());
                areas[row][col] = x;
                maxHeight = Integer.max(maxHeight, x);
            }
        }
        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int maxAreaCount = 0;
        for (int height = 0; height < maxHeight; ++height) {
            boolean[][] visited = new boolean[n][n];
            int areaCount = 0;
            for (int row = 0; row < n; ++row) {
                for (int col = 0; col < n; ++col) {
                    if (areas[row][col] <= height || visited[row][col]) {
                        continue;
                    }

                    ++areaCount;
                    Deque<int[]> queue = new ArrayDeque<>();
                    queue.offerLast(new int[] {row, col});
                    visited[row][col] = true;
                    while (!queue.isEmpty()) {
                        int[] curr = queue.removeFirst();
                        for (int[] direction : directions) {
                            int dx = curr[0] + direction[0];
                            int dy = curr[1] + direction[1];
                            if (dx < 0 || dy < 0 || dx >= n || dy >= n) {
                                continue;
                            }
                            if (areas[dx][dy] <= height || visited[dx][dy]) {
                                continue;
                            }
                            queue.offerLast(new int[] {dx, dy});
                            visited[dx][dy] = true;
                        }
                    }
                }
            }
            maxAreaCount = Integer.max(maxAreaCount, areaCount);
        }
        System.out.println(maxAreaCount);
    }
}
