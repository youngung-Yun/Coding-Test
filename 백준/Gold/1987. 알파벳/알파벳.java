import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        boolean[] visited = new boolean[26];
        visited[board[0][0] - 'A'] = true;
        dfs(board, visited, 0, 0, 1);
        System.out.println(result);
    }

    private static void dfs(char[][] board, boolean[] visited, int x, int y, int count) {
        result = Integer.max(result, count);

        for (int[] direction : directions) {
            int dx = x + direction[0];
            int dy = y + direction[1];
            if (dx < 0 || dy < 0 || dx >= board.length || dy >= board[0].length) {
                continue;
            }
            int idx = board[dx][dy] - 'A';
            if (visited[idx]) {
                continue;
            }

            visited[idx] = true;
            dfs(board, visited, dx, dy, count + 1);
            visited[idx] = false;
        }
    }
}