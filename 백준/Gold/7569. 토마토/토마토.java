import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int r, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 열 개수
        int m = Integer.parseInt(st.nextToken());
        // 행 개수
        int n = Integer.parseInt(st.nextToken());
        // 높이
        int h = Integer.parseInt(st.nextToken());
        int[][][] tomatoes = new int[h][n][m];
        int[][][] days = new int[h][n][m];
        Deque<Position> queue = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    int state = Integer.parseInt(input[k]);
                    tomatoes[i][j][k] = state;
                    if (state == 1) {
                        queue.offerLast(new Position(i, j, k));
                    }
                }
            }
        }
        // height, row, col
        int[][] directions = new int[][] {{1, 0, 0}, {-1 ,0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
        while (!queue.isEmpty()) {
            Position current = queue.removeFirst();
            for (int[] direction : directions) {
                int dh = current.height + direction[0];
                int dr = current.row + direction[1];
                int dc = current.col + direction[2];
                if (dh < 0 || dh >= h) {
                    continue;
                }
                if (dr < 0 || dr >= n) {
                    continue;
                }
                if (dc < 0 || dc >= m) {
                    continue;
                }
                if (tomatoes[dh][dr][dc] != 0) {
                    continue;
                }
                tomatoes[dh][dr][dc] = 1;
                days[dh][dr][dc] = days[current.height][current.row][current.col] + 1;
                queue.offerLast(new Position(dh, dr, dc));
            }
        }
        int minDays = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatoes[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    minDays = Integer.max(minDays, days[i][j][k]);
                }
            }
        }
        System.out.println(minDays);
    }

    private static class Position {
        public int height;
        public int row;
        public int col;

        public Position(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }
    }
}