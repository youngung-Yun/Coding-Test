import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] direction = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int n = Integer.parseInt(br.readLine());

        char[][] paint = new char[n][n];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++)
                paint[i][j] = row.charAt(j);
        }

        boolean[][] visited = new boolean[n][n];

        // 일반인 구역 수
        int normalCount = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    ++normalCount;
                    // BFS 시작
                    queue.offerLast(new int[]{i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] curr = queue.removeFirst();
                        for (int[] d : direction) {
                            int dx = curr[0] + d[0];
                            int dy = curr[1] + d[1];
                            if (dx < 0 || dy < 0 || dx >= n || dy >= n) {
                                continue;
                            }
                            if (visited[dx][dy]) {
                                continue;
                            }
                            if (paint[curr[0]][curr[1]] == paint[dx][dy]) {
                                visited[dx][dy] = true;
                                queue.offerLast(new int[]{dx, dy});
                            }
                        }
                    }
                }
            }
        }

        // 적록색약 구역 수
        int colorBlindCount = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    ++colorBlindCount;
                    // BFS 시작
                    queue.offerLast(new int[]{i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] curr = queue.removeFirst();
                        for (int[] d : direction) {
                            int dx = curr[0] + d[0];
                            int dy = curr[1] + d[1];
                            if (dx < 0 || dy < 0 || dx >= n || dy >= n) {
                                continue;
                            }
                            if (visited[dx][dy]) {
                                continue;
                            }
                            // 둘다 파랑
                            if (paint[curr[0]][curr[1]] == 'B' && paint[dx][dy] == 'B') {
                                visited[dx][dy] = true;
                                queue.offerLast(new int[]{dx, dy});
                            }
                            // 둘다 빨강 혹은 초록
                            if ((paint[curr[0]][curr[1]] == 'R' || paint[curr[0]][curr[1]] == 'G') && (paint[dx][dy] == 'R' || paint[dx][dy] == 'G')) {
                                visited[dx][dy] = true;
                                queue.offerLast(new int[]{dx, dy});
                            }
                        }
                    }
                }
            }
        }

        sb.append(normalCount).append(' ').append(colorBlindCount);
        System.out.println(sb.toString());
    }

}