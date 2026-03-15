import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    final static int[][] offset = { {0, 0}, {0, 1}, {1, 0}, {1, 1} };
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());
            char[][] tiles = init(n, m);

            sb.append('#').append(tc).append(' ')
                    .append(canReplaceTiles(tiles) ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);
    }

    private static char[][] init(int n, int m) throws Exception {
        char[][] grid = new char[n][m];
        for (int r = 0; r < n; r++) {
            String row = br.readLine();
            for (int c = 0; c < m; c++) {
                grid[r][c] = row.charAt(c);
            }
        }
        return grid;
    }

    private static boolean canReplaceTiles(char[][] tiles) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (tiles[r][c] == '.') {
                    continue;
                }

                for (int[] off : offset) {
                    int nr = r + off[0];
                    int nc = c + off[1];
                    if (!isValid(nr, nc) || tiles[nr][nc] == '.') {
                        return false;
                    }
                }
                for (int[] off : offset) {
                    int nr = r + off[0];
                    int nc = c + off[1];
                    tiles[nr][nc] = '.';
                }
            }
        }

        return true;
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}