import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

    static int row;
    static int col;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        row = Integer.parseInt(stk.nextToken());
        col = Integer.parseInt(stk.nextToken());

        map = new char[row][col];
        for (int r = 0; r < row; r++) {
            String line = bf.readLine();
            for (int c =0; c < col; c++) {
                map[r][c] = line.charAt(c);
            }
        }

        int ans = 0;
        boolean[][] visited = new boolean[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (map[r][c] == 'W' || visited[r][c]) {
                    continue;
                }
                ans = Integer.max(ans, bfs(r, c));
            }
        }

        System.out.println(ans);
    }

    static int bfs(int cr, int cc) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] distance = new int[row][col];
        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }
        distance[cr][cc] = 0;
        q.offer(new int[] {cr, cc});

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir : dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if (nr < 0 || nc < 0 || nr >= row || nc >= col) {
                    continue;
                }
                if (distance[nr][nc] != -1 || map[nr][nc] == 'W') {
                    continue;
                }
                distance[nr][nc] = distance[curr[0]][curr[1]] + 1;
                q.offer(new int[] {nr, nc});
            }
        }

        int farthest = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                farthest = Integer.max(farthest, distance[r][c]);
            }
        }
        return farthest;
    }
}