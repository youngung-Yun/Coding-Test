import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static int[] horseX = {-2, -1, 1, 2, 2, 1, -1, -2};
    final static int[] horseY = {1, 2, 2, 1, -1, -2, -2, -1};
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
    static int k;
    static int w;
    static int h;
    static int[][] field;
    static int[][][] distance;
    static boolean canReach = false;

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(bf.readLine());
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        w = Integer.parseInt(stk.nextToken());
        h = Integer.parseInt(stk.nextToken());
        field = new int[h][w];
        distance = new int[h][w][k+1];
        for (int r = 0; r < h; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < w; c++) {
                field[r][c] = Integer.parseInt(stk.nextToken());
            }
        }
        initDistance();

        bfs();

        if (!canReach) {
            System.out.println(-1);
        } else {
            int ans = w * h;
            for (int d : distance[h-1][w-1]) {
                if (d != -1) {
                    ans = Integer.min(ans, d);
                }
            }
            System.out.println(ans);
        }
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        distance[0][0][0] = 0;
        queue.offer(new int[] {0, 0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int x = current[0];
            int y = current[1];
            int horse = current[2];

            if (x == h - 1 && y == w - 1) {
                canReach = true;
                continue;
            }

            if (horse < k) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + horseX[i];
                    int ny = y + horseY[i];
                    if (!isValid(nx, ny)) {
                        continue;
                    }
                    if (field[nx][ny] == 1 || distance[nx][ny][horse+1] != -1) {
                        continue;
                    }
                    distance[nx][ny][horse+1] = distance[x][y][horse] + 1;
                    queue.offer(new int[] {nx, ny, horse + 1});
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!isValid(nx, ny)) {
                    continue;
                }
                if (field[nx][ny] == 1 || distance[nx][ny][horse] != -1) {
                    continue;
                }
                distance[nx][ny][horse] = distance[x][y][horse] + 1;
                queue.offer(new int[] {nx, ny, horse});
            }
        }
    }

    static void initDistance() {
        for (int[][] row : distance) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < h && y < w;
    }
}