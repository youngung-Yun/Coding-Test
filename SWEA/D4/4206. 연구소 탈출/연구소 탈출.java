import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    final static int INF = 10 * 10;
    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    static int r;
    static int c;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            r = Integer.parseInt(stk.nextToken());
            c = Integer.parseInt(stk.nextToken());

            List<int[]> virus = new ArrayList<>();
            int startX = 0;
            int startY = 0;
            int[][] map = new int[r][c];
            for (int row = 0; row < r; row++) {
                stk = new StringTokenizer(bf.readLine());
                for (int col = 0; col < c; col++) {
                    int object = Integer.parseInt(stk.nextToken());
                    map[row][col] = object;
                    if (object == 2) {
                        virus.add(new int[] {row, col});
                    } else if (object == 3) {
                        startX = row;
                        startY = col;
                    }
                }
            }
            int[][] virusMove = moveVirus(map, virus);
            int ans = INF;

            int[][] times = new int[r][c];
            for (int[] row : times) {
                Arrays.fill(row, INF);
            }
            boolean canEscape = false;

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[] {startX, startY});
            times[startX][startY] = 0;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                int nextTime = times[now[0]][now[1]] + 1;
                for (int[] dir : dirs) {
                    int nx = now[0] + dir[0];
                    int ny = now[1] + dir[1];
                    // 탈출
                    if (!isValidPos(nx, ny)) {
                        canEscape = true;
                        ans = nextTime;
                        break;
                    }
                    if (map[nx][ny] != 0 || times[nx][ny] != INF || nextTime >= virusMove[nx][ny]) {
                        continue;
                    }
                    times[nx][ny] = nextTime;
                    queue.offer(new int[] {nx, ny});
                }
            }

            sb.append('#').append(testcase).append(' ');
            if (canEscape) {
                sb.append(ans);
            } else if (virusMove[startX][startY] == INF) {
                sb.append("CANNOT ESCAPE");
            } else {
                sb.append("ZOMBIE");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int[][] moveVirus(int[][] map, List<int[]> virus) {
        int[][] virusMove = new int[r][c];
        for (int[] row : virusMove) {
            Arrays.fill(row, INF);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] v : virus) {
            queue.offer(v);
            virusMove[v[0]][v[1]] = 0;
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int[] dir : dirs) {
                int nx = now[0] + dir[0];
                int ny = now[1] + dir[1];
                if (!isValidPos(nx, ny)) {
                    continue;
                }
                if (map[nx][ny] == 1 || virusMove[nx][ny] != INF) {
                    continue;
                }
                virusMove[nx][ny] = virusMove[now[0]][now[1]] + 1;
                queue.offer(new int[] {nx, ny});
            }
        }

        return virusMove;
    }

    private static boolean canFindEscapePath(int[][] map, int x, int y) {
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int[] dir : dirs) {
                int nx = now[0] + dir[0];
                int ny = now[1] + dir[1];
                if (!isValidPos(nx, ny)) {
                    return true;
                }
                if (map[nx][ny] != 0 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
        return false;
    }

    private static boolean isValidPos(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < r && ny < c;
    }
}
