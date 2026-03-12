import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    final static int INF = -1;
    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} } ;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            char[][] map = new char[n][m];

            Queue<int[]> devilQueue = new ArrayDeque<>();
            Queue<int[]> moveQueue = new ArrayDeque<>();

            for (int r = 0; r < n; r++) {
                String row = bf.readLine();
                for (int c = 0; c < m; c++) {
                    char object = row.charAt(c);
                    map[r][c] = object;
                    if (object == 'S') {
                        moveQueue.offer(new int[] {r, c});
                    } else if (object == '*') {
                        devilQueue.offer(new int[] {r, c});
                    }
                }
            }

            int ans = INF;
            int time = 0;
            while (ans == INF && !moveQueue.isEmpty()) {
                ++time;
                int devilCount = devilQueue.size();
                while (devilCount-- > 0) {
                    int[] now = devilQueue.poll();
                    for (int[] dir : dirs) {
                        int nr = now[0] + dir[0];
                        int nc = now[1] + dir[1];
                        if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                            continue;
                        }
                        if (map[nr][nc] != '.') {
                            continue;
                        }
                        map[nr][nc] = '*';
                        devilQueue.offer(new int[] {nr, nc});
                    }
                }

                int moveCount = moveQueue.size();
                while (moveCount-- > 0) {
                    int[] now = moveQueue.poll();
                    for (int[] dir : dirs) {
                        int nr = now[0] + dir[0];
                        int nc = now[1] + dir[1];
                        if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                            continue;
                        }
                        if (map[nr][nc] == 'D') {
                            ans = time;
                            break;
                        } else if (map[nr][nc] != '.') {
                            continue;
                        }
                        map[nr][nc] = 'S';
                        moveQueue.offer(new int[] {nr, nc});
                    }
                }
            }
            sb.append('#').append(tc).append(' ')
                    .append(ans == INF ? "GAME OVER" : time).append('\n');
        }
        System.out.println(sb);
    }

}
