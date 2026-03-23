import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    static int row;
    static int col;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        row = Integer.parseInt(stk.nextToken());
        col = Integer.parseInt(stk.nextToken());

        char[][] map = new char[row][col];
        Queue<int[]> water = new ArrayDeque<>();
        Queue<int[]> hedgehog = new ArrayDeque<>();
        for (int r = 0; r < row; r++) {
            String line = bf.readLine();
            for (int c = 0; c < col; c++) {
                char object = line.charAt(c);
                map[r][c] = object;
                if (object == '*') {
                    water.offer(new int[] {r, c});
                } else if (object == 'S') {
                    hedgehog.offer(new int[] {r, c});
                }
            }
        }

        boolean[][] visited = new boolean[row][col];
        int ans = -1;
        int time = 0;
        while (ans == -1 && !hedgehog.isEmpty()) {
            ++time;
            int waterCount = water.size();
            while (waterCount-- > 0) {
                int[] curr = water.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (!isValid(nr, nc) || map[nr][nc] == 'X' || map[nr][nc] == 'D' || visited[nr][nc]) {
                        continue;
                    }
                    visited[nr][nc] = true;
                    water.offer(new int[] {nr, nc});
                }
            }

            int hedgehogCount = hedgehog.size();
            while (hedgehogCount-- > 0) {
                int[] curr = hedgehog.poll();

                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (!isValid(nr, nc) || map[nr][nc] == 'X' || visited[nr][nc]) {
                        continue;
                    } else if (map[nr][nc] == 'D') {
                        ans = time;
                        break;
                    }
                    visited[nr][nc] = true;
                    hedgehog.offer(new int[] {nr, nc});
                }
            }
        }

        System.out.println(ans == -1 ? "KAKTUS" : ans);
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < row && c < col;
    }
}