import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int[][] region;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(token.nextToken());
            int x = Integer.parseInt(token.nextToken());
            region = new int[n][n];
            for (int r = 0; r < n; r++) {
                token = new StringTokenizer(bf.readLine());
                for (int c = 0; c < n; c++) {
                    region[r][c] = Integer.parseInt(token.nextToken());
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += checkRow(i, n, x) ? 1 : 0;
                ans += checkCol(i, n, x) ? 1 : 0;
            }

            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static boolean checkRow(int rowNum, int n, int x) {
        // [height, count]
        List<int[]> flatLands = new ArrayList<>();
        int height = region[rowNum][0];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int now = region[rowNum][i];
            if (height == now) {
                ++count;
            } else {
                // 높이차 2 이상인 지대가 붙어있으면 건설 불가능
                if (Math.abs(height - now) >= 2) {
                    return false;
                }
                flatLands.add(new int[] {height, count});
                height = now;
                count = 1;
            }
        }
        flatLands.add(new int[] {height, count});

        for (int i = 1; i < flatLands.size(); i++) {
            int[] current = flatLands.get(i);
            int[] prev = flatLands.get(i - 1);

            // 현재(오른쪽)이 더 높은 경우
            if (current[0] > prev[0]) {
                if (prev[1] < x) {
                    return false;
                }
            } else {
            // 왼쪽이 더 높은 경우
                if (current[1] < x) {
                    return false;
                }
                current[1] -= x;
            }
        }
        return true;
    }

    static boolean checkCol(int colNum, int n, int x) {
        // [height, count]
        List<int[]> flatLands = new ArrayList<>();
        int height = region[0][colNum];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int now = region[i][colNum];
            if (height == now) {
                ++count;
            } else {
                if (Math.abs(height - now) >= 2) {
                    return false;
                }
                flatLands.add(new int[]{height, count});
                height = now;
                count = 1;
            }
        }
        flatLands.add(new int[]{height, count});

        for (int i = 1; i < flatLands.size(); i++) {
            int[] current = flatLands.get(i);
            int[] prev = flatLands.get(i - 1);

            if (current[0] > prev[0]) {
                if (prev[1] < x) {
                    return false;
                }
            } else {
                if (current[1] < x) {
                    return false;
                }
                current[1] -= x;
            }
        }
        return true;
    }
}