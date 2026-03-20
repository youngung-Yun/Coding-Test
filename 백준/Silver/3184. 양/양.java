import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        char[][] yard = new char[n][m];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++) {
                yard[r][c] = row.charAt(c);
            }
        }

        int totalSheep = 0;
        int totalWolf = 0;
        boolean[][] visited = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (yard[r][c] == '#' || visited[r][c]) {
                    continue;
                }
                int sheep = 0;
                int wolf = 0;
                visited[r][c] = true;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[] {r, c});

                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    if (yard[curr[0]][curr[1]] == 'o') {
                        ++sheep;
                    } else if (yard[curr[0]][curr[1]] == 'v') {
                        ++wolf;
                    }

                    for (int[] dir : dirs) {
                        int nr = curr[0] + dir[0];
                        int nc = curr[1] + dir[1];
                        if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                            continue;
                        }
                        if (visited[nr][nc] || yard[nr][nc] == '#') {
                            continue;
                        }
                        visited[nr][nc] = true;
                        queue.offer(new int[] {nr, nc});
                    }
                }

                if (sheep > wolf) {
                    totalSheep += sheep;
                } else {
                    totalWolf += wolf;
                }
            }
        }

        System.out.printf("%d %d", totalSheep, totalWolf);
    }
}