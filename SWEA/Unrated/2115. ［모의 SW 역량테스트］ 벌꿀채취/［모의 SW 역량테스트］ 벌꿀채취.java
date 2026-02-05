import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int m;
    static int c;
    static int[][] honey;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            ans = 0;
            StringTokenizer token = new StringTokenizer(bf.readLine());
            // 3 <= n <= 10
            n = Integer.parseInt(token.nextToken());
            // 1 <= m <= 5
            m = Integer.parseInt(token.nextToken());
            c = Integer.parseInt(token.nextToken());
            honey = new int[n][n];
            for (int i = 0; i < n; i++) {
                token = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    honey[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            /*
             * 1. 겹치지 않는 두 직사각형 선택
             * 2. 최대 양을 초과하지 않는 선에서 범위 중 수익이 가장 많은 꿀 채취
             * 3. max 비교 후 갱신
             */
            for (int x1 = 0; x1 < n; x1++) {
                for (int y1 = 0; y1 <= n - m; y1++) {
                    for (int x2 = 0; x2 < n; x2++) {
                        for (int y2 = 0; y2 <= n - m; y2++) {
                            if (isOverwrapped(x1, y1, x2, y2)) {
                                continue;
                            }
                            int income = harvestHoney(x1, y1, x2, y2);
                            ans = Integer.max(ans, income);
                        }
                    }
                }
            }

            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static int harvestHoney(int x1, int y1, int x2, int y2) {
        return harvestHoney(x1, y1) + harvestHoney(x2, y2);
    }

    static int harvestHoney(int x, int y) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = honey[x][y+i];
        }

        int maxIncome = 0;
        for (int bitset = 0; bitset < Math.pow(2, m); bitset++) {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < m; i++) {
                int mask = 0b1 << i;
                if ((bitset & mask) != 0) {
                    sum += arr[i];
                    list.add(arr[i]);
                }
            }
            if (sum > c) {
                continue;
            }
            int income = 0;
            for (int e : list) {
                income += e * e;
            }
            maxIncome = Integer.max(maxIncome, income);
        }
        return maxIncome;
    }

    static boolean isOverwrapped(int x1, int y1, int x2, int y2) {
        if (x1 != x2) {
            return false;
        }
        boolean[] tmp = new boolean[n];
        for (int y = y1; y < y1 + m; y++) {
            tmp[y] = true;
        }
        for (int y = y2; y < y2 + m; y++) {
            if (tmp[y]) {
                return true;
            }
        }
        return false;
    }
}
