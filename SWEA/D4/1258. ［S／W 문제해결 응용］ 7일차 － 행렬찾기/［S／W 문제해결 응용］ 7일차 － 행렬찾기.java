import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            for (int r = 0; r < n; r++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = Integer.parseInt(token.nextToken());
                }
            }

            List<int[]> submatrix = new ArrayList<>();
            boolean[][] visited = new boolean[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (matrix[r][c] == 0) {
                        continue;
                    }
                    if (visited[r][c]) {
                        continue;
                    }
                    submatrix.add(bfs(matrix, r, c, visited, n));
                }
            }
            submatrix.sort((a1, a2) -> {
                int size1 = a1[0] * a1[1];
                int size2 = a2[0] * a2[1];
                if (size1 == size2) {
                    return Integer.compare(a1[0], a2[0]);
                }
                return Integer.compare(size1, size2);
            });

            sb.append('#').append(testCase).append(' ').append(submatrix.size()).append(' ');
            for (int[] sub : submatrix) {
                sb.append(sub[0]).append(' ').append(sub[1]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static int[] bfs(int[][] matrix, int x, int y, boolean[][] visited, int n) {
        int maxX = x;
        int maxY = y;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] {x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.removeFirst();
            maxX = Integer.max(maxX, curr[0]);
            maxY = Integer.max(maxY, curr[1]);

            for (int[] dir : dirs) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (matrix[nx][ny] == 0) {
                    continue;
                }
                queue.offerLast(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
        return new int[] {maxX - x + 1, maxY - y + 1};
    }
}