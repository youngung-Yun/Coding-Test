import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    static int r;
    static int c;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());

        Queue<int[]> fires = new ArrayDeque<>();
        Queue<int[]> moves = new ArrayDeque<>();

        char[][] maze = new char[r][c];
        for (int x = 0; x < r; x++) {
            String row = bf.readLine();
            for (int y = 0; y < c; y++) {
                char object = row.charAt(y);
                maze[x][y] = object;
                if (object == 'J') {
                    moves.offer(new int[] {x, y});
                } else if (object == 'F') {
                    fires.offer(new int[] {x, y});
                }
            }
        }

        int ans = -1;
        int time = 0;
        while (ans == -1 && !moves.isEmpty()) {
            ++time;
            // 불 이동
            int fireCount = fires.size();
            while (fireCount-- > 0) {
                int[] curr = fires.poll();
                for (int[] d : dirs) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (!isValid(nr, nc) || maze[nr][nc] != '.') {
                        continue;
                    }
                    maze[nr][nc] = 'F';
                    fires.offer(new int[] {nr ,nc});
                }
            }

            // 이동
            int moveCount = moves.size();
            while (moveCount-- > 0) {
                int[] curr = moves.poll();
                for (int[] d : dirs) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    // 탈출
                    if (!isValid(nr, nc)) {
                        ans = time;
                        break;
                    }
                    if (maze[nr][nc] != '.') {
                        continue;
                    }
                    maze[nr][nc] = 'J';
                    moves.offer(new int[] {nr, nc});
                }
            }
        }

        System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < r && y < c;
    }
}