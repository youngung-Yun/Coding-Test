import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INF = -1;
    final static int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

    static int n;
    static int[][] grid;
    static int currentSize = 2;
    static int eatFish = 0;
    static int time = 0;
    static boolean existEatableFish = true;
    static int currentR = 0;
    static int currentC = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        grid = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                int object = Integer.parseInt(stk.nextToken());
                grid[r][c] = object;
                if (object == 9) {
                    currentR = r;
                    currentC = c;
                }
            }
        }

        while (existEatableFish) {
            bfs();
        }

        System.out.println(time);
    }

    private static void bfs() {
        int nextR = n;
        int nextC = n;
        int shortest = n * n;
        int[][] distance = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                distance[r][c] = INF;
            }
        }

        distance[currentR][currentC] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {currentR, currentC});

        existEatableFish = false;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (!isValid(nr, nc) || distance[nr][nc] != INF || grid[nr][nc] > currentSize) {
                    continue;
                }
                distance[nr][nc] = distance[r][c] + 1;
                queue.offer(new int[] {nr, nc});
                if (grid[nr][nc] != 0 && grid[nr][nc] < currentSize) {
                    existEatableFish = true;
                    if (shortest < distance[nr][nc]) {
                        continue;
                    }
                    if (nextR > nr || (nextR == nr && nextC > nc)) {
                        nextR = nr;
                        nextC = nc;
                        shortest = distance[nr][nc];
                    }
                }
            }
        }

        if (!existEatableFish) {
            return;
        }
        grid[currentR][currentC] = 0;
        grid[nextR][nextC] = 9;
        currentR = nextR;
        currentC = nextC;
        ++eatFish;
        if (eatFish == currentSize) {
            ++currentSize;
            eatFish = 0;
        }
        time += distance[nextR][nextC];
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}