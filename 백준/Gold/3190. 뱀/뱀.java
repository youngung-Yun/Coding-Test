import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // 우 - 하 - 좌 - 상
    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        // '.' : 빈 칸, 'A' : 사과, '*' : 뱀
        char[][] board = initBoard(n);
        int k = Integer.parseInt(bf.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(stk.nextToken()) - 1;
            int c = Integer.parseInt(stk.nextToken()) - 1;
            board[r][c] = 'A';
        }

        int l = Integer.parseInt(bf.readLine());
        Command[] command = new Command[l];
        for (int i = 0; i < l; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int time = Integer.parseInt(stk.nextToken());
            char dir = stk.nextToken().charAt(0);
            command[i] = new Command(time, dir);
        }

        // [r, c]
        List<int[]> snake = new ArrayList<>();
        snake.add(new int[] {0, 0});
        board[0][0] = '*';
        int dir = 0;

        int elapsed = 0;
        int commandIdx = 0;
        while (true) {
            ++elapsed;

            int[] head = snake.get(0);
            int nr = head[0] + dirs[dir][0];
            int nc = head[1] + dirs[dir][1];
            // 벽이나 몸에 부딪힘
            if (!isValid(nr, nc, n) || board[nr][nc] == '*') {
                break;
            }

            if (board[nr][nc] == 'A') {
                board[nr][nc] = '.';
            } else {
                int[] tail = snake.get(snake.size() - 1);
                board[tail[0]][tail[1]] = '.';
                snake.remove(snake.size() - 1);

            }

            // 머리 추가
            snake.add(0, new int[] {nr, nc});
            board[nr][nc] = '*';

            if (commandIdx < l && command[commandIdx].time == elapsed) {
                char turn = command[commandIdx].dir;
                // 왼쪽
                if (turn == 'L') {
                    dir = (dir + 3) % 4;
                // 오른쪽
                } else {
                    dir = (dir + 1) % 4;
                }
                ++commandIdx;
            }
        }
        System.out.println(elapsed);
    }

    static class Command {
        public int time;
        public char dir;

        public Command(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    static char[][] initBoard(int n) {
        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = '.';
            }
        }
        return board;
    }

    static boolean isValid(int r, int c, int n) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    static void print(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            for (char col : row) {
                sb.append(col).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}