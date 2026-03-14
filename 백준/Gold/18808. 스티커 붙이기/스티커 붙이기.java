import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] grid = new int[n][m];

        int[] [][] stickers = new int[k][][];
        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(bf.readLine());
            int row = Integer.parseInt(stk.nextToken());
            int col = Integer.parseInt(stk.nextToken());
            int[][] sticker = new int[row][col];
            for (int r = 0; r < row; r++) {
                stk = new StringTokenizer(bf.readLine());
                for (int c = 0; c < col; c++) {
                    sticker[r][c] = Integer.parseInt(stk.nextToken());
                }
            }
            stickers[i] = sticker;
        }

        for (int i = 0; i < k; i++) {
            int[][] sticker = stickers[i];
            boolean attached = false;
            for (int d = 0; d < 4; d++) {
                int row = sticker.length;
                int col = sticker[0].length;
                for (int r = 0; r < n - row + 1; r++) {
                    if (attached) {
                        break;
                    }
                    for (int c = 0; c < m - col + 1; c++) {
                        if (canAttach(grid, sticker, r, c, row, col)) {
                            attachSticker(grid, sticker, r, c, row, col);
                            attached = true;
                            break;
                        }
                    }
                }
                if (attached) {
                    break;
                } else {
                    sticker = rotateSticker(sticker, row, col);
                }
            }
        }

        int ans = countSticker(grid, n, m);
        System.out.println(ans);
    }

    private static boolean canAttach(int[][] grid, int[][] sticker, int startR, int startC, int row, int col) {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (sticker[r][c] == 1 && grid[startR+r][startC+c] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void attachSticker(int[][] grid, int[][] sticker, int startR, int startC, int row, int col) {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (sticker[r][c] == 1) {
                    grid[startR+r][startC+c] = 1;
                }
            }
        }
    }

    private static int[][] rotateSticker(int[][] sticker, int row, int col) {
        int[][] rotatedSticker = new int[col][row];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                rotatedSticker[c][row-1-r] = sticker[r][c];
            }
        }
        return rotatedSticker;
    }

    private static int countSticker(int[][] grid, int n, int m) {
        int count = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                count += grid[r][c];
            }
        }
        return count;
    }
}