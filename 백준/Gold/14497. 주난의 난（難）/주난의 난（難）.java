import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(bf.readLine());
        int startR = Integer.parseInt(stk.nextToken()) - 1;
        int startC = Integer.parseInt(stk.nextToken()) - 1;
        int endR = Integer.parseInt(stk.nextToken()) - 1;
        int endC = Integer.parseInt(stk.nextToken()) - 1;

        char[][] classroom = new char[n][m];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++) {
                classroom[r][c] = row.charAt(c);
            }
        }

        final int INF = n * m + 1;
        int[][] distance = new int[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                distance[r][c] = INF;
            }
        }
        distance[startR][startC] = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[] {startR, startC, 0});

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            int r = now[0];
            int c = now[1];
            int d = now[2];
            if (r == endR && c == endC) {
                break;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }
                int nextDistance = d;
                if (classroom[nr][nc] == '1' || classroom[nr][nc] == '#') {
                    ++nextDistance;
                }

                if (nextDistance >= distance[nr][nc]) {
                    continue;
                }

                if (classroom[nr][nc] == '0') {
                    deque.offerFirst(new int[] {nr, nc, nextDistance});
                } else {
                    deque.offerLast(new int[] {nr, nc, nextDistance});
                }
                distance[nr][nc] = nextDistance;
            }
        }

        System.out.println(distance[endR][endC]);
    }
}

