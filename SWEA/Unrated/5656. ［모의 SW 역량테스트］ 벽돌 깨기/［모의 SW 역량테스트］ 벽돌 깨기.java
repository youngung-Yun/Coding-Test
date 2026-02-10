import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {-1, 0, 1, 0};
    static int n;
    static int w;
    static int h;
    static int[][] playground;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());

            n = Integer.parseInt(stk.nextToken());
            w = Integer.parseInt(stk.nextToken());
            h = Integer.parseInt(stk.nextToken());
            playground = new int[h][w];
            ans = h * w;

            for (int r = 0; r < h; r++) {
                stk = new StringTokenizer(bf.readLine());
                for (int c = 0; c < w; c++) {
                    playground[r][c] = Integer.parseInt(stk.nextToken());
                }
            }
            /*
             * 1. 구슬을 발사하는 열 조합 구함
             * 2. 그 조합으로 구슬 발사
             * 3. 처음 충돌한 벽돌부터 BFS로 연쇄적으로 벽돌 제거
             * 4. 중력 작용
             * 5. 다 쏘면 남은 벽돌 개수 세기
             */
            dfs(copyGrid(playground), 0);
            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int[][] grid, int depth) {
        ans = Integer.min(ans, countBrick(grid));
        if (depth == n) {
            return;
        }

        for (int col = 0; col < w; col++) {
            // 벽돌이 없는 열은 시도하지 않음
            for (int row = 0; row < h; row++) {
                if (grid[row][col] != 0) {
                    int[][] newGrid = play(copyGrid(grid), row, col);
                    dfs(newGrid, depth + 1);
                    break;
                }
            }
        }
    }

    static int[][] play(int[][] grid, int row, int col) {
         // [x, y, range]
         Queue<int[]> queue = new ArrayDeque<>();
         queue.offer(new int[] {row, col, grid[row][col]});
         grid[row][col] = 0;
         while (!queue.isEmpty()) {
             int[] curr = queue.remove();
             int x = curr[0];
             int y = curr[1];
             int range = curr[2];
             for (int i = 0; i < 4; i++) {
                 int nx = x + dx[i];
                 int ny = y + dy[i];
                 for (int k = 1; k < range; k++) {
                     if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                         break;
                     }
                     if (grid[nx][ny] == 0) {
                         nx += dx[i];
                         ny += dy[i];
                         continue;
                     }
                     queue.offer(new int[] {nx, ny, grid[nx][ny]});
                     grid[nx][ny] = 0;
                     nx += dx[i];
                     ny += dy[i];
                 }
             }
         }
         // 중력 작용
         activateGravity(grid);
         return grid;
    }

    static int[][] copyGrid(int[][] grid) {
        int[][] copy = new int[h][w];
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                copy[r][c] = grid[r][c];
            }
        }
        return copy;
    }

    static void activateGravity(int[][] grid) {
        for (int c = 0; c < w; c++) {
            int low = h - 1;
            for (int r = h - 1; r >= 0; r--) {
                if (grid[r][c] != 0) {
                    int tmp = grid[r][c];
                    grid[r][c] = 0;
                    grid[low][c] = tmp;
                    --low;
                }
            }
        }
    }

    static int countBrick(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            for (int col : row) {
                count += col != 0 ? 1 : 0;
            }
        }
        return count;
    }
}