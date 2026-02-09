import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Solution {

    static int n;
    static int m;
    static int[][] tunnel;
    static boolean[][] visited;

    final static int[][][] dirs = {
            {{}},
            {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}, // +
            {{-1, 0}, {1, 0}}, // I
            {{0, 1}, {0, -1}}, // -
            {{-1, 0}, {0, 1}}, // ㄴ
            {{1, 0}, {0, 1}}, //
            {{0, -1}, {1, 0}}, // ㄱ
            {{0, -1}, {-1, 0}}
    }; //

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            int l = Integer.parseInt(stk.nextToken());

            tunnel = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                stk = new StringTokenizer(bf.readLine());
                for (int j = 0; j < m; j++) {
                    tunnel[i][j] = Integer.parseInt(stk.nextToken());
                }
            }

            int ans = bfs(r, c, l);
            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    private static int bfs(int r, int c, int time) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c, 1});
        visited[r][c] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            ++count;
            int[] curr = queue.remove();
            int x = curr[0];
            int y = curr[1];
            int t = curr[2];

            if (t >= time) {
                continue;
            }

            int pipe = tunnel[x][y];
            for (int[] dir : dirs[pipe]) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (tunnel[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                if(!isConnected(x, y, nx, ny)) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny, t + 1});
            }
        }
        return count;
    }

    // 두 파이프가 연결되어 있다면 서로 다른 파이프로 이동 할 수 있음
    private static boolean isConnected(int x1, int y1, int x2, int y2) {
        int pipe1 = tunnel[x1][y1];
        int pipe2 = tunnel[x2][y2];
        boolean canGo1 = false;
        boolean canGo2 = false;
        for (int[] dir : dirs[pipe1]) {
            int nx = x1 + dir[0];
            int ny = y1 + dir[1];
            if (nx == x2 && ny == y2) {
                canGo1 = true;
                break;
            }
        }

        for (int[] dir : dirs[pipe2]) {
            int nx = x2 + dir[0];
            int ny = y2 + dir[1];
            if (nx == x1 && ny == y1) {
                canGo2 = true;
                break;
            }
        }
        return canGo1 && canGo2;
    }
}