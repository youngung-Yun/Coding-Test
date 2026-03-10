import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    final static int INF = 100 * 100 + 1;

    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());

        int[][] maze = new int[n][m];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++) {
                maze[r][c] = row.charAt(c) - '0';
            }
        }

        int[][] counts = new int[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                counts[r][c] = INF;
            }
        }

        counts[0][0] = 0;
        // [r, c, count]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        pq.add(new int[] {0, 0, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int r = now[0];
            int c = now[1];
            int count = now[2];
            if (counts[r][c] < count) {
                continue;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (!isValid(nr, nc)) {
                    continue;
                }

                int breakCount = maze[nr][nc];

                if (counts[nr][nc] > counts[r][c] + breakCount) {
                    counts[nr][nc] = counts[r][c] + breakCount;
                    pq.add(new int[] {nr, nc, counts[nr][nc]});
                }
            }
        }

        System.out.println(counts[n-1][m-1]);
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}
