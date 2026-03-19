import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    static int n;
    static List<int[]> empty;
    static List<int[]> teachers;
    static char[][] corridor;
    static boolean canHideAll = false;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        empty = new ArrayList<>();
        teachers = new ArrayList<>();
        corridor = new char[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                char object = stk.nextToken().charAt(0);
                corridor[r][c] = object;
                if (object == 'T') {
                    teachers.add(new int[] {r, c});
                } else if (object == 'X') {
                    empty.add(new int[] {r, c});
                }
            }
        }

        dfs(new int[3], 0, 0);

        System.out.println(canHideAll ? "YES" : "NO");
    }

    private static boolean simulate() {
        for (int[] teacher : teachers) {
            for (int[] dir : dirs) {
                int nr = teacher[0] + dir[0];
                int nc = teacher[1] + dir[1];
                while (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                    if (corridor[nr][nc] == 'S') {
                        return false;
                    } else if (corridor[nr][nc] == 'O') {
                        break;
                    }
                    nr += dir[0];
                    nc += dir[1];
                }
            }
        }
        return true;
    }

    private static void dfs(int[] idx, int depth, int curr) {
        if (canHideAll) {
            return;
        }
        if (depth == 3) {
            setup(idx, 'O');
            if (simulate()) {
                canHideAll = true;
            }
            setup(idx, 'X');
            return;
        }

        for (int i = curr; i < empty.size(); i++) {
            idx[depth] = i;
            dfs(idx, depth + 1, i + 1);
        }
    }

    private static void setup(int[] idx, char object) {
        for (int i : idx) {
            int[] coord = empty.get(i);
            int r = coord[0];
            int c = coord[1];
            corridor[r][c] = object;
        }
    }
}