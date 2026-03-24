import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int startR = 0;
        int startC = 0;
        int buildingCount = 0;
        char[][] map = new char[n][m];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++) {
                char ch = row.charAt(c);
                map[r][c] = ch;
                if (ch == '@') {
                    startR = r;
                    startC = c;
                } else if (ch == '#' || ch == '*') {
                    ++buildingCount;
                }
            }
        }

        int collapseCount = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] dir : dirs) {
            int nr = startR;
            int nc = startC;
            for (int d = 0; d < 2; d++) {
                nr += dir[0];
                nc += dir[1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == '|') {
                    break;
                } else if (map[nr][nc] == '*') {
                    ++collapseCount;
                    map[nr][nc] = '.';
                    queue.offer(new int[] {nr, nc});
                } else if (map[nr][nc] == '#') {
                    map[nr][nc] = '*';
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                } else if (map[nr][nc] == '#') {
                    map[nr][nc] = '*';
                }
                else if (map[nr][nc] == '*') {
                    ++collapseCount;
                    map[nr][nc] = '.';
                    queue.offer(new int[] {nr, nc});
                }
            }
        }

        System.out.printf("%d %d", collapseCount, buildingCount - collapseCount);
    }
}