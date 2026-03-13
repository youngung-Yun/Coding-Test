import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[][] rooms = new int[n][n];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < n; c++) {
                rooms[r][c] = row.charAt(c) - '0';
            }
        }

        final int MAX = n * n;

        int[][] distance = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                distance[r][c] = MAX;
            }
        }
        distance[0][0] = 0;
        // [r, c, cost]
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[] {0, 0, 0});

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            int r = now[0];
            int c = now[1];
            int cost = now[2];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    continue;
                }
                int nextCost = cost + (rooms[nr][nc] + 1) % 2;
                if (nextCost >= distance[nr][nc]) {
                    continue;
                }
                // 검은 방
                if (rooms[nr][nc] == 0) {
                    deque.offerLast(new int[] {nr, nc, nextCost});
                } else {
                    deque.offerFirst(new int[] {nr, nc, nextCost});
                }
                distance[nr][nc] = nextCost;
            }
        }

        System.out.println(distance[n-1][n-1]);
    }
}

