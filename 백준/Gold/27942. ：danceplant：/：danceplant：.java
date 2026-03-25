import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[][] grid = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                grid[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        int cr = (n - 1) / 2;
        int cc = (n - 1) / 2;
        int width = 2;
        int height = 2;
        int total = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int max = 0;
            int dir = 0;
            for (int d = 0; d < 4; d++) {
                int sum = 0;
                // 우
                if (d == 0) {
                    int nc = cc + width;
                    if (nc >= n) {
                        continue;
                    }
                    for (int r = cr; r < cr + height; r++) {
                        sum += grid[r][nc];
                    }
                } else if (d == 1) {
                    // 좌
                    int nc = cc - 1;
                    if (nc < 0) {
                        continue;
                    }
                    for (int r = cr; r < cr + height; r++) {
                        sum += grid[r][nc];
                    }
                } else if (d == 2) {
                    // 하
                    int nr = cr + height;
                    if (nr >= n) {
                        continue;
                    }
                    for (int c = cc; c < cc + width; c++) {
                        sum += grid[nr][c];
                    }
                } else if (d == 3) {
                    // 상
                    int nr = cr - 1;
                    if (nr < 0) {
                        continue;
                    }
                    for (int c = cc; c < cc + width; c++) {
                        sum += grid[nr][c];
                    }
                }
                if (sum >= max) {
                    max = sum;
                    dir = d;
                }
            }
            if (max == 0) {
                break;
            }
            total += max;
            if (dir == 0) {
                ++width;
                sb.append('R');
            } else if (dir == 1) {
                --cc;
                ++width;
                sb.append('L');
            } else if (dir == 2) {
                ++height;
                sb.append('D');
            } else if (dir == 3) {
                --cr;
                ++height;
                sb.append('U');
            }
        }
        System.out.println(total);
        System.out.println(sb);
    }
}