import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    final static int[][] offsets = { {0, 0}, {1, -1}, {1, 1}, {2, -2}, {2, -1}, {2, 0}, {2, 1}, {2, 2} };

    static char[][] paint;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        // height = n, width: 2n
        paint = new char[n+1][n*2+1];
        for (int r = 0; r <= n; r++) {
            for (int c = 0; c <= 2 * n; c++) {
                paint[r][c] = ' ';
            }
        }

        recursionPaint(1, n, n);

        StringBuilder sb = new StringBuilder();
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= 2*n; c++) {
                sb.append(paint[r][c]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    // r, c = 삼각형의 중심
    private static void recursionPaint(int r, int c, int height) {
        if (height == 3) {
            for (int[] offset : offsets) {
                int nr = r + offset[0];
                int nc = c + offset[1];
                paint[nr][nc] = '*';
            }
            return;
        }

        int half = height / 2;
        recursionPaint(r, c, half);
        recursionPaint(r + half, c - half, half);
        recursionPaint(r + half, c + half, half);
    }
}