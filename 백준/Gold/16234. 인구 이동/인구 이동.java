import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int min = Integer.parseInt(stk.nextToken());
        int max = Integer.parseInt(stk.nextToken());

        int[][] world = new int[n][n];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                world[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        int elapsed = 0;
        while (true) {
            boolean isBorderlineOpened = false;
            boolean[][] visited = new boolean[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (visited[r][c]) {
                        continue;
                    }
                    int count = 0;
                    int population = 0;
                    List<int[]> list = new ArrayList<>();
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[] {r, c});
                    visited[r][c] = true;
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        list.add(now);
                        ++count;
                        population += world[now[0]][now[1]];
                        for (int[] dir : dirs) {
                            int nr = now[0] + dir[0];
                            int nc = now[1] + dir[1];
                            if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                                continue;
                            }
                            if (visited[nr][nc]) {
                                continue;
                            }
                            int diff = Math.abs(world[now[0]][now[1]] - world[nr][nc]);
                            if (diff < min || diff > max) {
                                continue;
                            }
                            q.offer(new int[] {nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                    if (count == 1) {
                        continue;
                    }

                    isBorderlineOpened = true;
                    for (int[] e : list) {
                        world[e[0]][e[1]] = population / count;
                    }
                }
            }

            if (!isBorderlineOpened) {
                break;
            }
            ++elapsed;
        }
        System.out.println(elapsed);
    }
}