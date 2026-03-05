import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

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

            sb.append('#').append(testcase).append(' ');

            boolean canReachToPlayer = canReachToPlayer(map, virus, startX, startY);
            boolean canFindEscapePath = canFindEscapePath(map, startX, startY);
            
            // 바이러스가 닿을 수 없고 탈출 불가능
            if (!canReachToPlayer && !canFindEscapePath) {
                sb.append("CANNOT ESCAPE").append('\n');
                continue;
            }

            int ans = -1;
            boolean becomeZombie = false;
            Queue<int[]> virusQueue = new ArrayDeque<>();
            for (int[] v : virus) {
                virusQueue.offer(v);
            }
            boolean[][] visited = new boolean[r][c];
            Queue<int[]> moveQueue = new ArrayDeque<>();
            moveQueue.offer(new int[] {startX, startY});
            visited[startX][startY] = true;

            for (int time = 1; time <= r * c; time++) {
                if (ans != -1) {
                    break;
                } else if (moveQueue.isEmpty()) {
                    becomeZombie = true;
                    break;
                }

                // 바이러스 이동
                int virusCount = virusQueue.size();
                while (virusCount-- > 0) {
                    int[] now = virusQueue.poll();
                    for (int[] dir : dirs) {
                        int nx = now[0] + dir[0];
                        int ny = now[1] + dir[1];
                        if (!isValidPos(nx, ny)) {
                            continue;
                        }
                        if (map[nx][ny] != 0) {
                            continue;
                        }
                        map[nx][ny] = 2;
                        virusQueue.offer(new int[] {nx ,ny});
                    }
                }

                // 이동
                int moveCount = moveQueue.size();
                while (moveCount-- > 0) {
                    int[] now = moveQueue.poll();
                    for (int[] dir : dirs) {
                        int nx = now[0] + dir[0];
                        int ny = now[1] + dir[1];
                        // 탈출
                        if (!isValidPos(nx, ny)) {
                            ans = time;
                            break;
                        }
                        if (map[nx][ny] != 0 || visited[nx][ny]) {
                            continue;
                        }

                        visited[nx][ny] = true;
                        moveQueue.offer(new int[] {nx, ny});
                    }
                }
            }

            if (becomeZombie) {
                sb.append("ZOMBIE").append('\n');
            } else {
                sb.append(ans).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static boolean canReachToPlayer(int[][] map, List<int[]> virus, int x, int y) {

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];
        for (int[] v : virus) {
            queue.offer(v);
            visited[v[0]][v[1]] = true;
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == x && now[1] == y) {
                return true;
            }
            for (int[] dir : dirs) {
                int nx = now[0] + dir[0];
                int ny = now[1] + dir[1];
                if (!isValidPos(nx, ny)) {
                    continue;
                }
                if (map[nx][ny] == 1 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
        return false;
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
