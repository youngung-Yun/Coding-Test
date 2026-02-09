import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Solution {

    final static int MAX = 100 * 100 * 10;
    // 상 하 좌 우
    final static int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = Integer.parseInt(bf.readLine());
            grid = new int[n][n];
            for (int r = 0; r < n; r++) {
                String row = bf.readLine();
                for (int c = 0; c < n; c++) {
                    grid[r][c] = row.charAt(c) - '0';
                }
            }

            int[][] cost = new int[n][n];
            for (int[] row : cost) {
                Arrays.fill(row, MAX);
            }
            // [cost, x, y] : 출발 지점에서 (x,y)까지 cost 걸리는 경우
            PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[0], a2[0]));
            pq.add(new int[] {0, 0, 0});
            cost[0][0] = 0;
            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int c = current[0];
                int x = current[1];
                int y = current[2];
                if (c > cost[x][y]) {
                    continue;
                }

                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        continue;
                    }
                    // 출발 지점에서 (x, y)를 거쳐 (nx, ny)로 가는 비용이 현재 (nx, ny)로 가는 비용보다 저렴하면 갱신
                    if (c + grid[nx][ny] < cost[nx][ny]) {
                        cost[nx][ny] = c + grid[nx][ny];
                        pq.add(new int[] {cost[nx][ny], nx, ny});
                    }
                }
            }
            sb.append('#').append(testCase).append(' ')
                    .append(cost[n-1][n-1]).append('\n');
        }
        System.out.println(sb);
    }
}