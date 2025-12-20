import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            int[][] farm = new int[row][col];

            for (int j = 0; j < count; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                farm[x][y] = 1;
            }

            int result = 0;
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (farm[j][k] == 1) {
                        ++result;
                        farm[j][k] = 0;
                        bfs(farm, j, k);
                    }
                }
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int[][] matrix, int nx, int ny) {
        for (int[] direction : directions) {
            int dx = nx + direction[0];
            int dy = ny + direction[1];
            if (dx < 0 || dy < 0 || dx >= matrix.length || dy >= matrix[0].length) {
                continue;
            }
            if (matrix[dx][dy] == 1) {
                matrix[dx][dy] = 0;
                bfs(matrix, dx, dy);
            }
        }
    }
}
