import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1} };
    final static int INF = -1;
    final static int WIDTH = 5;

    static int ans = INF;
    static int[][][][] boards;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        boards = new int[5][4][WIDTH][WIDTH];
        for (int i = 0; i < 5; i++) {
            int[][] board = new int[WIDTH][WIDTH];
            for (int r = 0; r < WIDTH; r++) {
                StringTokenizer stk = new StringTokenizer(bf.readLine());
                for (int c = 0; c < WIDTH; c++) {
                    board[r][c] = Integer.parseInt(stk.nextToken());
                }
            }

            boards[i][0] = board;
            for (int r = 1; r < 4; r++) {
                int[][] rotated = rotate(boards[i][r-1]);
                boards[i][r] = rotated;
            }
        }

        int[] seq = new int[WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            seq[i] = i;
        }
        sequenceDfs(seq, 0);

        System.out.println(ans);
    }

    private static void sequenceDfs(int[] seq, int depth) {
        if (depth == WIDTH) {
            int[] dir = new int[WIDTH];
            directionDfs(seq, dir, 0);
            return;
        }

        for (int i = depth; i < WIDTH; i++) {
            swap(seq, depth, i);
            sequenceDfs(seq, depth + 1);
            swap(seq, depth, i);
        }
    }

    private static void directionDfs(int[] seq, int[] dir, int depth) {
        if (depth == WIDTH) {
            simulate(seq, dir);
            return;
        }

        for (int d = 0; d < 4; d++) {
            dir[depth] = d;
            directionDfs(seq, dir, depth + 1);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
         arr[a] = arr[b];
         arr[b] = tmp;
    }

    private static void simulate(int[] seq, int[] dir) {
        int[][][] maze = new int[WIDTH][WIDTH][WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            maze[i] = boards[seq[i]][dir[i]];
        }

        if (maze[0][0][0] == 0 || maze[WIDTH-1][WIDTH-1][WIDTH-1] == 0) {
            return;
        }

        int[][][] distance = initDistance();
        distance[0][0][0] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 0});

        while (!queue.isEmpty() && distance[WIDTH-1][WIDTH-1][WIDTH-1] == INF) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int z = now[2];
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                int nz = z + d[2];
                if (!isValid(nx, ny, nz) || distance[nx][ny][nz] != INF || maze[nx][ny][nz] == 0) {
                    continue;
                }

                distance[nx][ny][nz] = distance[x][y][z] + 1;
                queue.offer(new int[] {nx, ny, nz});
            }
        }

        if (distance[WIDTH-1][WIDTH-1][WIDTH-1] != INF) {
            if (ans == INF || ans > distance[WIDTH-1][WIDTH-1][WIDTH-1]) {
                ans = distance[WIDTH-1][WIDTH-1][WIDTH-1];
            }
        }
    }

    private static int[][] rotate(int[][] board) {
        int[][] rotated = new int[WIDTH][WIDTH];
        for (int r = 0; r < WIDTH; r++) {
            for (int c = 0; c < WIDTH; c++) {
                rotated[c][WIDTH-1-r] = board[r][c];
            }
        }
        return rotated;
    }

    private static int[][][] initDistance() {
        int[][][] distance = new int[WIDTH][WIDTH][WIDTH];
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < WIDTH; y++) {
                for (int z = 0; z < WIDTH; z++) {
                    distance[x][y][z] = INF;
                }
            }
        }
        return distance;
    }

    private static boolean isValid(int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0 && x < WIDTH && y < WIDTH && z < WIDTH;
    }
}