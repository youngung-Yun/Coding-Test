import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

    static int id = -1;
    static int n;
    static int m;
    static int[][] grid;
    static int[][] ans;

    static Map<Integer, Integer> sizeMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        grid = new int[n][m];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++) {
                grid[r][c] = row.charAt(c) - '0';
            }
        }

        ans = new int[n][m];

        id = -1;
        for (int r = 0; r < n; r++) {
            for (int c =0; c < m; c++) {
                if (grid[r][c] != 0) {
                    continue;
                }
                bfs(r, c, id);
                --id;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] != 1) {
                    continue;
                }
                ++ans[r][c];
                set.clear();
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (!isValid(nr, nc) || grid[nr][nc] == 1 || set.contains(grid[nr][nc])) {
                        continue;
                    }
                    set.add(grid[nr][nc]);
                    ans[r][c] = (ans[r][c] + sizeMap.get(grid[nr][nc])) % 10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : ans) {
            for (int col : row) {
                sb.append(col);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void bfs(int sr, int sc, int id) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {sr, sc});
        grid[sr][sc] = id;
        int size = 0;
        while (!q.isEmpty()) {
            ++size;
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if (!isValid(nr, nc) || grid[nr][nc] != 0) {
                    continue;
                }
                grid[nr][nc] = id;
                q.offer(new int[] {nr, nc});
            }
        }
        sizeMap.put(id, size);
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}