import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    final static int[][] dirs = { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };
    static List<FireBall> fireballs = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(stk.nextToken()) - 1;
            int c = Integer.parseInt(stk.nextToken()) - 1;
            int mass = Integer.parseInt(stk.nextToken());
            int speed = Integer.parseInt(stk.nextToken());
            int direction = Integer.parseInt(stk.nextToken());
            fireballs.add(new FireBall(r, c, mass, speed, direction));
        }

        for (int i = 0; i < k; i++) {
            simulate();
        }

        int ans = 0;
        for (FireBall fireBall : fireballs) {
            ans += fireBall.mass;
        }

        System.out.println(ans);
    }

    private static void simulate() {
        // [mass, speed, oddCount, evenCount, currentDirection]
        int[][] [] grid = new int[n][n] [5];
        moveFireBalls(grid);

        List<FireBall> nextFireBalls = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int count = grid[r][c][2] + grid[r][c][3];
                if (count == 0) {
                    continue;
                } else if (count == 1) {
                    nextFireBalls.add(new FireBall(r, c, grid[r][c][0], grid[r][c][1], grid[r][c][4]));
                } else {
                    int dividedMass = grid[r][c][0] / 5;
                    if (dividedMass == 0) {
                        continue;
                    }
                    int dividedSpeed = grid[r][c][1] / count;
                    // 방향이 모두 짝수거나 모두 홀수
                    int startDirection;
                    if (grid[r][c][2] == 0 || grid[r][c][3] == 0) {
                        startDirection = 0;
                    } else {
                        startDirection = 1;
                    }
                    for (int d = startDirection; d < 8; d += 2) {
                        nextFireBalls.add(new FireBall(r, c, dividedMass, dividedSpeed, d));
                    }
                }
            }
        }
        fireballs = nextFireBalls;
    }

    static class FireBall {
        public int row;
        public int col;
        public int mass;
        public int speed;
        public int direction;

        public FireBall(int row, int col, int mass, int speed, int direction) {
            this.row = row;
            this.col = col;
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
        }
    }

    private static void moveFireBalls(int[][][] grid) {
        for (FireBall fireBall : fireballs) {
            int r = fireBall.row;
            int c = fireBall.col;
            int mass = fireBall.mass;
            int d = fireBall.direction;
            int speed = fireBall.speed;

            int nr = correct(r + (dirs[d][0] * (speed % n)));
            int nc = correct(c + (dirs[d][1] * (speed % n)));

            grid[nr][nc][0] += mass;
            grid[nr][nc][1] += speed;
            if (d % 2 == 0) {
                ++grid[nr][nc][3];
            } else {
                ++grid[nr][nc][2];
            }
            grid[nr][nc][4] = d;
        }
    }

    private static int correct(int curr) {
        if (curr < 0) {
            return n + curr;
        } else if (curr >= n) {
            return curr % n;
        }
        return curr;
    }
}