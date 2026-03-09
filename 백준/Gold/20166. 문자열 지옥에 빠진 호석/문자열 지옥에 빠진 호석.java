import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    final static int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1} };

    final static Map<String, Integer> map = new HashMap<>();

    static char[][] grid;
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        grid = new char[n][m];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++) {
                grid[r][c] = row.charAt(c);
            }
        }

        char[] arr = new char[5];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                dfs(r, c, 0, arr);
            }
        }

        for (int i = 0; i < k; i++) {
            String word = bf.readLine();
            System.out.println(map.getOrDefault(word, 0));
        }
    }

    private static void dfs(int r, int c, int depth, char[] arr) {

        arr[depth] = grid[r][c];
        String word = makeWord(arr, depth);
        map.put(word, map.getOrDefault(word, 0) + 1);

        if (depth == 4) {
            return;
        }

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0) {
                nr = n - 1;
            } else if (nr >= n) {
                nr = 0;
            }

            if (nc < 0) {
                nc = m - 1;
            } else if (nc >= m) {
                nc = 0;
            }
            dfs(nr, nc, depth + 1, arr);
        }
    }

    private static String makeWord(char[] arr, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}