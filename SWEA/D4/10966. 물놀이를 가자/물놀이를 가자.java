import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static final int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            char[][] pool = new char[n][m];
            for (int r = 0; r < n; r++) {
                String row = bf.readLine();
                for (int c = 0; c < m; c++) {
                    pool[r][c] = row.charAt(c);
                }
            }

            List<int[]> list = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (pool[r][c] == 'W') {
                        list.add(new int[] {r, c});
                    }
                }
            }
            int ans = bfs(pool, n, m, list);
            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    private static int bfs(char[][] matrix, int n, int m, List<int[]> list) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] start : list) {
            visited[start[0]][start[1]] = true;
            queue.offer(new int[] {start[0], start[1], 0});
        }

        int distance = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.remove();
            distance += now[2];

            for (int[] dir : dirs) {
                int nr = now[0] + dir[0];
                int nc = now[1] + dir[1];
                if (!isValid(nr, nc, n, m) || visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc, now[2] + 1});
            }
        }
        return distance;
    }

    private static boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}
