import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    final static int[][] dirs = { {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1} };
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // fishes[i] : i번 물고기의 정보
        Fish[] fishes = new Fish[17];

        int sharkR = 0;
        int shartC = 0;
        int shartDir = 0;
        int[][] sea = new int[4][4];
        for (int r = 0; r < 4; r++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < 4; c++) {
                int number = Integer.parseInt(stk.nextToken());
                int direction = Integer.parseInt(stk.nextToken()) - 1;
                fishes[number] = new Fish(r, c, direction);
                sea[r][c] = number;
                if (r == 0 && c == 0) {
                    shartDir = direction;
                    ans = number;
                    fishes[number].isAlive = false;
                    sea[0][0] = -1;
                }
            }
        }

        simulate(sharkR, shartC, shartDir, fishes, sea, ans);

        System.out.println(ans);
    }

    private static void simulate(int sharkR, int sharkC, int sharkDir, Fish[] fishes, int[][] sea, int sum) {
        ans = Integer.max(ans, sum);
        // 1. 물고기 움직임
        moveFishes(fishes, sea);

        // 2. 상어 움직일 수 있는 경우의 수마다 재귀
        int nr = sharkR + dirs[sharkDir][0];
        int nc = sharkC + dirs[sharkDir][1];
        while (nr >= 0 && nc >= 0 && nr < 4 && nc < 4) {
            int[][] copySea = copySea(sea);
            Fish[] copyFishes = copyFishes(fishes);

            if (copySea[nr][nc] != 0) {
                int number = copySea[nr][nc];
                Fish eatanFish = copyFishes[number];
                eatanFish.isAlive = false;
                copySea[sharkR][sharkC] = 0;
                copySea[nr][nc] = -1;
                simulate(nr, nc, eatanFish.direction, copyFishes, copySea, sum + number);
            }
            nr += dirs[sharkDir][0];
            nc += dirs[sharkDir][1];
        }
    }

    private static int[][] copySea(int[][] sea) {
        int[][] copy = new int[4][4];
        for (int r = 0; r < 4; r++) {
            for (int c = 0;c < 4; c++) {
                copy[r][c] = sea[r][c];
            }
        }
        return copy;
    }

    private static Fish[] copyFishes(Fish[] fishes) {
        Fish[] copy = new Fish[17];
        for (int i = 1; i <= 16; i++) {
            Fish fish = fishes[i];
            copy[i] = new Fish(fish.row, fish.col, fish.direction);
            copy[i].isAlive = fish.isAlive;
        }
        return copy;
    }

    private static class Fish {
        public int row;
        public int col;
        public int direction;
        public boolean isAlive;

        public Fish(int row, int col, int direction) {
            this.row = row;
            this.col = col;
            this.direction = direction;
            isAlive = true;
        }
    }

    private static void moveFishes(Fish[] fishes, int[][] sea) {
        for (int i = 1; i <= 16; i++) {
            Fish fish = fishes[i];
            if (!fish.isAlive) {
                continue;
            }
            for (int d = fish.direction; d <= fish.direction + 8; d++) {
                int nr = fish.row + dirs[d%8][0];
                int nc = fish.col + dirs[d%8][1];
                if (nr < 0 || nc < 0 || nr >= 4 || nc >= 4 || sea[nr][nc] == -1) {
                    fish.direction = (fish.direction + 1) % 8;
                } else if (sea[nr][nc] == 0) {
                    sea[fish.row][fish.col] = 0;
                    sea[nr][nc] = i;
                    fish.row = nr;
                    fish.col = nc;
                    break;
                } else {
                    // 물고기 상태 스왑
                    int othersNumber = sea[nr][nc];
                    Fish other = fishes[othersNumber];
                    swapFish(fish, other);
                    int tmp = sea[fish.row][fish.col];
                    sea[fish.row][fish.col] = sea[other.row][other.col];
                    sea[other.row][other.col] = tmp;
                    break;
                }
            }
        }
    }

    private static void swapFish(Fish fish, Fish other) {
        int rowTmp = fish.row;
        fish.row = other.row;
        other.row = rowTmp;

        int colTmp = fish.col;
        fish.col = other.col;
        other.col = colTmp;
    }
}