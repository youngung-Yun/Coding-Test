import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int width = Integer.parseInt(br.readLine());
            int[][] table = new int[width][width];
            for (int r = 0; r < width; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < width; c++) {
                    table[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            /*
             * S극(2)은 위부터, N극(1)은 아래부터 이동
             */
            for (int elapsed = 0; elapsed < 100; ++elapsed) {
                moveMagnets(table, width, width);
            }
            int answer = countDeadlock(table, width, width);
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    static int[] nPoleDir = new int[] {1, 0};
    static int[] sPoleDir = new int[] {-1, 0};

    static void moveMagnets(int[][] table, int r, int c) {
        // N극 이동
        for (int row = r - 1; row >= 0; --row) {
            for (int col = 0; col < c; ++col) {
                if (table[row][col] != 1) {
                    continue;
                }
                // 테이블 아래로 떨어짐
                if (row == r - 1) {
                    table[row][col] = 0;
                    continue;
                }
                int nx = row + nPoleDir[0];
                int ny = col + nPoleDir[1];
                if (table[nx][ny] == 0) {
                    table[nx][ny] = 1;
                    table[row][col] = 0;
                }
            }
        }

        // S극 이동
        for (int row = 0; row < r; ++row) {
            for (int col = 0; col < c; ++col) {
                if (table[row][col] != 2) {
                    continue;
                }
                // 테이블 아래로 떨어짐
                if (row == 0) {
                    table[row][col] = 0;
                    continue;
                }
                int nx = row + sPoleDir[0];
                int ny = col + sPoleDir[1];
                if (table[nx][ny] == 0) {
                    table[nx][ny] = 2;
                    table[row][col] = 0;
                }
            }
        }
    }

    static int countDeadlock(int[][] table, int r, int c) {
        int count = 0;
        for (int row = 0; row < r - 1; ++row) {
            for (int col = 0; col < c; ++col) {
                if (table[row][col] == 1 && table[row+1][col] == 2) {
                    ++count;
                }
            }
        }
        return count;
    }
}