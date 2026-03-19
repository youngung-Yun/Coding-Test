import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int row = Integer.parseInt(stk.nextToken());
        int col = Integer.parseInt(stk.nextToken());

        char[][] grid = new char[row][col];
        for (int r = 0; r < row; r++) {
            String input = bf.readLine();
            for (int c = 0; c < col; c++) {
                grid[r][c] = input.charAt(c);
            }
        }

        char[][] empty = new char[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                empty[r][c] = '.';
            }
        }

        List<int[]> cross = new ArrayList<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == '.') {
                    continue;
                }
                int d = 1;
                while (isCrossAll(grid, r, c, d, row, col)) {
                    ++d;
                }
                --d;
                if (d == 0) {
                    continue;
                }

                cross.add(new int[] {r + 1, c + 1, d});
                paintCross(empty, r, c, d);
            }
        }

        if (!isSameGrid(grid, empty, row, col)) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(cross.size()).append('\n');
            for (int[] c : cross) {
                for (int e : c) {
                    sb.append(e).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
        }
    }

    private static boolean isCrossAll(char[][] grid, int r, int c, int d, int row, int col) {
        if (r - d < 0 || grid[r-d][c] != '*') {
            return false;
        } else if (r + d >= row || grid[r+d][c] != '*') {
            return false;
        } else if (c - d < 0 || grid[r][c-d] != '*') {
            return false;
        } else if (c + d >= col || grid[r][c+d] != '*') {
            return false;
        }
        return true;
    }

    private static void paintCross(char[][] grid, int r, int c, int width) {
        for (int d = 0; d <= width; d++) {
            grid[r+d][c] = grid[r-d][c] = grid[r][c+d] = grid[r][c-d] = '*';
        }
    }

    private static boolean isSameGrid(char[][] origin, char[][] target, int row, int col) {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (origin[r][c] != target[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}