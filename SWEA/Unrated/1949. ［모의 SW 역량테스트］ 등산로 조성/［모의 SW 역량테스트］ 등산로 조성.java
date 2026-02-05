import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    static int[][] map;
    static int n;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            ans = 0;
            StringTokenizer token = new StringTokenizer(bf.readLine());
            // 3 <= n <= 8
            n = Integer.parseInt(token.nextToken());
            // 1 <= k <= 5
            int k = Integer.parseInt(token.nextToken());

            // 최대 높이 봉우리 좌표
            List<int[]> maxHeightList = new ArrayList<>();
            int maxHeight = 0;
            map = new int[n][n];
            for (int r = 0; r < n; r++) {
                token = new StringTokenizer(bf.readLine());
                for (int c = 0; c < n; c++) {
                    int height = Integer.parseInt(token.nextToken());
                    map[r][c] = height;
                    if (maxHeight < height) {
                        maxHeightList.clear();
                        maxHeightList.add(new int[] {r, c});
                        maxHeight = height;
                    } else if (maxHeight == height) {
                        maxHeightList.add(new int[] {r, c});
                    }
                }
            }

            /*
             * 각 지형에 대해 1부터 최대 K까지 높이를 낮춘 후
             * 각 가장 높은 봉우리부터 시작하는 DFS로 최대 길이 계산
             */
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    for (int m = 1; m <= k; m++) {
                        // 0 미만으로 깎는 경우 제외
                        if (map[r][c] < m) {
                            break;
                        }
                        map[r][c] -= m;
                        for (int[] start : maxHeightList) {
                            dfs(start[0], start[1], 1);
                        }
                        map[r][c] += m;
                    }
                }
            }
            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y, int depth) {
        ans = Integer.max(ans, depth);

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (!isValid(nx, ny)) {
                continue;
            }
            if (map[nx][ny] >= map[x][y]) {
                continue;
            }
            dfs(nx, ny, depth + 1);
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}