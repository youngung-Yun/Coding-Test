import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    static Set<Integer> set = new HashSet<>();
    static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        grid = new int[5][5];

        for (int r = 0; r < 5; r++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < 5; c++) {
                grid[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                backtracking(r, c, grid[r][c], 0);
            }
        }

        System.out.println(set.size());
    }

    static void backtracking(int r, int c, int number, int depth) {
        if (depth == 5) {
            set.add(number);
            return;
        }

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) {
                continue;
            }
            backtracking(nr, nc, (number * 10) + grid[nr][nc], depth + 1);
        }
    }
}