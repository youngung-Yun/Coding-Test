import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    final static int[][] dirs = { {}, {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
    static int[] dice;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // above, forward, below, backward, left, right
        dice = new int[] {0, 0, 0, 0, 0, 0};

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] board = new int[n][m];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < m; c++) {
                board[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < k; i++) {
            int command = Integer.parseInt(stk.nextToken());

            int nx = x + dirs[command][0];
            int ny = y + dirs[command][1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            // 동쪽으로
            if (command == 1) {
                rollLeft();
            // 서쪽으로
            } else if (command == 2) {
                rollRight();
            // 북쪽으로
            } else if (command == 3) {
                rollUp();
            // 남쪽으로
            } else if (command == 4) {
                rollDown();
            }

            x = nx;
            y = ny;
            if (board[x][y] == 0) {
                board[x][y] = dice[2];
            } else {
                dice[2] = board[x][y];
                board[x][y] = 0;
            }

            sb.append(dice[0]).append('\n');
        }
        System.out.println(sb);
    }

    // above, forward, below, backward, left, right
    static void rollLeft() {
        int[] newDice = new int[6];
        newDice[0] = dice[5];
        newDice[1] = dice[1];
        newDice[2] = dice[4];
        newDice[3] = dice[3];
        newDice[4] = dice[0];
        newDice[5] = dice[2];

        dice = newDice;
    }

    static void rollRight() {
        int[] newDice = new int[6];
        newDice[0] = dice[4];
        newDice[1] = dice[1];
        newDice[2] = dice[5];
        newDice[3] = dice[3];
        newDice[4] = dice[2];
        newDice[5] = dice[0];

        dice = newDice;
    }

    static void rollUp() {
        int[] newDice = new int[6];
        newDice[0] = dice[1];
        newDice[1] = dice[2];
        newDice[2] = dice[3];
        newDice[3] = dice[0];
        newDice[4] = dice[4];
        newDice[5] = dice[5];

        dice = newDice;
    }

    static void rollDown() {
        int[] newDice = new int[6];
        newDice[0] = dice[3];
        newDice[1] = dice[0];
        newDice[2] = dice[1];
        newDice[3] = dice[2];
        newDice[4] = dice[4];
        newDice[5] = dice[5];

        dice = newDice;
    }
}