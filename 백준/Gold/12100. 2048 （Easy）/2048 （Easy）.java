import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] initBoard;
    static int width;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        width = Integer.parseInt(bf.readLine());
        initBoard = new int[width][width];
        for (int r = 0; r < width; r++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < width; c++) {
                initBoard[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        dfs(new int[5], 0);

        System.out.println(ans);
    }

    private static void dfs(int[] dir, int depth) {
        if (depth == 5) {
            simulate(dir);
            return;
        }

        for (int d = 0; d < 4; d++) {
            dir[depth] = d;
            dfs(dir, depth + 1);
        }
    }

    private static void simulate(int[] dir) {
        int[][] board = copyBoard();

        /*
         * 1. 해당 방향으로 블록 이동
         * 2. 붙어있는 같은 숫자의 블록 합침
         * 3. 다시 해당 방향으로 블록 이동
         * 4. 5번 이동 후 최댓값 구함
         */
        for (int d : dir) {
            slide(board, d);
            merge(board, d);
            slide(board, d);
        }

        int max = getMaxBlock(board);
        ans = Integer.max(ans, max);
    }

    // [상, 하, 좌, 우]
    private static void slide(int[][] board, int dir) {
        if (dir == 0) {
            slideUp(board);
        } else if (dir == 1) {
            slideDown(board);
        } else if (dir == 2) {
            slideLeft(board);
        } else if (dir == 3) {
            slideRight(board);
        }
    }

    private static void slideUp(int[][] board) {
        for (int c = 0; c < width; c++) {
            int idx = 0;
            for (int r = 0; r < width; r++) {
                if (board[r][c] != 0) {
                    int number = board[r][c];
                    board[r][c] = 0;
                    board[idx][c] = number;
                    ++idx;
                }
            }
        }
    }

    private static void slideDown(int[][] board) {
        for (int c = 0; c < width; c++) {
            int idx = width - 1;
            for (int r = width - 1; r >= 0; r--) {
                if (board[r][c] != 0) {
                    int number = board[r][c];
                    board[r][c] = 0;
                    board[idx][c] = number;
                    --idx;
                }
            }
        }
    }

    private static void slideLeft(int[][] board) {
        for (int r = 0; r < width; r++) {
            int idx = 0;
            for (int c = 0; c < width; c++) {
                if (board[r][c] != 0) {
                    int number = board[r][c];
                    board[r][c] = 0;
                    board[r][idx] = number;
                    ++idx;
                }
            }
        }
    }

    private static void slideRight(int[][] board) {
        for (int r = 0; r < width; r++) {
            int idx = width - 1;
            for (int c = width - 1; c >= 0; c--) {
                if (board[r][c] != 0) {
                    int number = board[r][c];
                    board[r][c] = 0;
                    board[r][idx] = number;
                    --idx;
                }
            }
        }
    }

    private static void merge(int[][] board, int dir) {
        if (dir == 0) {
            mergeUp(board);
        } else if (dir == 1) {
            mergeDown(board);
        } else if (dir == 2) {
            mergeLeft(board);
        } else if (dir == 3) {
            mergeRight(board);
        }
    }

    private static void mergeUp(int[][] board) {
        for (int c = 0; c < width; c++) {
            for (int r = 1; r < width; r++) {
                if (board[r][c] == board[r-1][c]) {
                    board[r-1][c] *= 2;
                    board[r][c] = 0;
                }
            }
        }
    }

    private static void mergeDown(int[][] board) {
        for (int c = 0; c < width; c++) {
            for (int r = width - 2; r >= 0; r--) {
                if (board[r][c] == board[r+1][c]) {
                    board[r+1][c] *= 2;
                    board[r][c] = 0;
                }
            }
        }
    }

    private static void mergeLeft(int[][] board) {
        for (int r = 0; r < width; r++) {
            for (int c = 1; c < width; c++) {
                if (board[r][c] == board[r][c-1]) {
                    board[r][c-1] *= 2;
                    board[r][c] = 0;
                }
            }
        }
    }

    private static void mergeRight(int[][] board) {
        for (int r = 0; r < width; r++) {
            for (int c = width - 2; c >= 0; c--) {
                if (board[r][c] == board[r][c + 1]) {
                    board[r][c + 1] *= 2;
                    board[r][c] = 0;
                }
            }
        }
    }

    private static int getMaxBlock(int[][] board) {
        int max = 0;
        for (int r = 0; r < width; r++) {
            for (int c = 0; c < width; c++) {
                max = Integer.max(max, board[r][c]);
            }
        }
        return max;
    }

    private static int[][] copyBoard() {
        int[][] board = new int[width][width];
        for (int r = 0; r < width; r++) {
            for (int c = 0; c < width; c++) {
                board[r][c] = initBoard[r][c];
            }
        }
        return board;
    }
}
