import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[][] rowVisited = new boolean[9][10];
    static boolean[][] colVisited = new boolean[9][10];
    // (r / 3) * 3 + (c / 3)
    static boolean[][] squareVisited = new boolean[9][10];
    static int[][] board = new int[9][9];

    static boolean finished = false;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<int[]> empty = new ArrayList<>();

        for (int r = 0; r < 9; r++) {
            String row = bf.readLine();
            for (int c = 0; c < 9; c++) {
                int number = row.charAt(c) - '0';
                board[r][c] = number;
                if (number == 0) {
                    empty.add(new int[] {r, c});
                } else {
                    rowVisited[r][number] = true;
                    colVisited[c][number] = true;
                    squareVisited[(r/3)*3+(c/3)][number] = true;
                }
            }
        }
        backtrack(empty, 0);
    }

    static void backtrack(List<int[]> list, int depth) {
        if (finished) {
            return;
        } else if (depth == list.size()) {
            finished = true;
            StringBuilder sb = new StringBuilder();
            for (int[] row : board) {
                for (int col : row) {
                    sb.append(col);
                }
                sb.append('\n');
            }
            System.out.println(sb);
            return;
        }

        int[] curr = list.get(depth);
        int r = curr[0];
        int c = curr[1];
        for (int number = 1; number < 10; number++) {
            if (rowVisited[r][number] || colVisited[c][number] || squareVisited[(r/3)*3+(c/3)][number]) {
                continue;
            }
            rowVisited[r][number] = true;
            colVisited[c][number] = true;
            squareVisited[(r/3)*3+(c/3)][number] = true;
            board[r][c] = number;
            backtrack(list, depth + 1);
            board[r][c] = 0;
            rowVisited[r][number] = false;
            colVisited[c][number] = false;
            squareVisited[(r/3)*3+(c/3)][number] = false;
        }
    }
}