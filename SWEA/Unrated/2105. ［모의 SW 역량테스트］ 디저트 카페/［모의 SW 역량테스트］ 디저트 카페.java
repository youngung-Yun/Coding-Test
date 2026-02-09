import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Solution {

    final static int[] dx = {-1, -1, 1, 1};
    final static int[] dy = {-1, 1, 1, -1};
    static int n;
    static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            n = Integer.parseInt(bf.readLine());
            grid = new int[n][n];
            for (int r = 0; r < n; r++) {
                StringTokenizer stk = new StringTokenizer(bf.readLine());
                for (int c = 0; c < n; c++) {
                    grid[r][c] = Integer.parseInt(stk.nextToken());
                }
            }

            int ans = -1;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    for (int w = 1; w < n; w++) {
                        for (int h = 1; h < n; h++) {
                            ans = Integer.max(ans, travel(r, c, w, h));
                            ans = Integer.max(ans, travel(r, c, h, w));
                        }
                    }
                }
            }
            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static int travel(int x, int y, int w, int h) {
        Set<Integer> set = new HashSet<>();
        int nx = x;
        int ny = y;
        for (int i = 0; i < 4; i++) {
            int length = i % 2 == 0 ? w : h;
            for (int l = 0; l < length; l++) {
                nx += dx[i];
                ny += dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    return -1;
                }
                if (set.contains(grid[nx][ny])) {
                    return -1;
                }
                set.add(grid[nx][ny]);
            }
        }
        return set.size();
    }
}