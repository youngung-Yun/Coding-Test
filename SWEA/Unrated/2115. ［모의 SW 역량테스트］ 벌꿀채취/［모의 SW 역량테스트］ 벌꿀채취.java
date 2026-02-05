import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int m;
    static int c;
    static int[][] maxIncomes;
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
            maxIncomes = new int[n][n];
            for (int i = 0; i < n; i++) {
                token = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    honey[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    maxIncomes[i][j] = getMaxIncomes(i, j);
                }
            }

            for (int x1 = 0; x1 < n; x1++) {
                for (int y1 = 0; y1 <= n - m; y1++) {
                    for (int x2 = 0; x2 < n; x2++) {
                        for (int y2 = 0; y2 <= n - m; y2++) {
                            if (isOverlapped(x1, y1, x2, y2)) {
                                continue;
                            }
                            ans = Integer.max(ans, maxIncomes[x1][y1] + maxIncomes[x2][y2]);
                        }
                    }
                }
            }

            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static int getMaxIncomes(int x, int y) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            // 범위 밖 제외
            if (y + i >= n) {
                return 0;
            }
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

    static boolean isOverlapped(int x1, int y1, int x2, int y2) {
        if (x1 != x2) {
            return false;
        }
        int bit1 = 0;
        for (int y = y1; y < y1 + m; y++) {
            bit1 += (0b1 << y);
        }
        int bit2 = 0;
        for (int y = y2; y < y2 + m; y++) {
            bit2 += (0b1 << y);
        }
        return (bit1 & bit2) != 0;
    }
}
