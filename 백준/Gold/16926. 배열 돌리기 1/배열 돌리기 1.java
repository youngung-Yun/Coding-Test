import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][m];
        for (int row = 0; row < n; ++row) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; ++col) {
                matrix[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            rotate(matrix, n, m);
        }
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int col : row) {
                sb.append(col).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    /*
     * 1. 왼쪽 위부터 시작
     * 2. 한 바퀴 돌 때까지 순회
     * 3. 다 돌았으면 다음 안쪽 사각형으로
     */
    static void rotate(int[][] matrix, int r, int c) {
        boolean[][] visited = new boolean[r][c];
        int start = 0;
        while (!visited[start][start]) {
            int x = start;
            int y = start;
            int prev = matrix[x][y];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                while (isValidPosition(nx, ny, r, c) && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    int now = matrix[nx][ny];
                    matrix[nx][ny] = prev;
                    prev = now;
                    x = nx;
                    y = ny;
                    nx += dir[0];
                    ny += dir[1];
                }
            }
            ++start;
        }
    }

    static boolean isValidPosition(int x, int y, int r, int c) {
        return x >= 0 && y >= 0 && x < r && y < c;
    }
}