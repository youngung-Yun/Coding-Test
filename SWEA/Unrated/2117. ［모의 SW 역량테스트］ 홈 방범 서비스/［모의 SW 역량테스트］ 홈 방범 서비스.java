import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Solution {

    static final int[][] offsets = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            int[][] city = new int[n][n];
            for (int r = 0; r < n; r++) {
                stk = new StringTokenizer(bf.readLine());
                for (int c = 0; c < n; c++) {
                    city[r][c] = Integer.parseInt(stk.nextToken());
                }
            }

            int maxHomeCount = 0;

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    boolean[][] visited = new boolean[n][n];
                    int homeCount = 0;
                    for (int k = 0; k < 2 * n; k++) {
                        for (int dx = 0; dx <= k; dx++) {
                            int dy = k - dx;
                            for (int[] offset : offsets) {
                                int nx = r + (dx * offset[0]);
                                int ny = c + (dy * offset[1]);
                                if (!isValid(nx, ny, n)) {
                                    continue;
                                }
                                if (visited[nx][ny]) {
                                    continue;
                                }
                                if (city[nx][ny] == 1) {
                                    ++homeCount;
                                }
                                visited[nx][ny] = true;
                            }
                        }
                        int cost = (k * k) + (k + 1) * (k + 1);
                        int benefit = (homeCount * m) - cost;
                        if (benefit >= 0) {
                            maxHomeCount = Integer.max(maxHomeCount, homeCount);
                        }
                    }
                }
            }

            sb.append('#').append(testCase).append(' ')
                    .append(maxHomeCount).append('\n');
        }
        System.out.println(sb);
    }

    private static boolean isValid(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}