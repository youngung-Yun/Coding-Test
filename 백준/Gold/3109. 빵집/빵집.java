import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    final static int[] offsets = {-1, 0, 1};
    static int r;
    static int c;
    static char[][] grid;
    static int ans = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());

        grid = new char[r][c];
        for (int row = 0; row < r; row++) {
            String line = bf.readLine();
            for (int col = 0; col < c; col++) {
                grid[row][col] = line.charAt(col);
            }
        }

        visited = new boolean[r][c];
        for (int row = 0; row < r; row++) {
            visited[row][0] = true;
            dfs(row, 0);
        }
        System.out.println(ans);
    }

    private static boolean dfs(int row, int col) {
        if (col == c - 1) {
            ++ans;
            return true;
        }

        for (int offset : offsets) {
            int nr = row + offset;
            int nc = col + 1;

            if (!isValid(nr, nc) || visited[nr][nc] || grid[nr][nc] == 'x') {
                continue;
            }

            visited[nr][nc] = true;
            boolean result = dfs(nr, nc);
            if (result) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValid(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < r && nc < c;
    }
}
