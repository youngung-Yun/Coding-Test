import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int k = Integer.parseInt(reader.readLine());

        char[][] map = new char[n][m];
        for (int r = 0; r < n; r++) {
            String row = reader.readLine();
            for (int c = 0; c < m; c++) {
                map[r][c] = row.charAt(c);
            }
        }

        // [J, O, I]
        // prefixSum[r][c] == [0, 0]부터 [r, c]까지의 누적합
        int[][][] prefixSum = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixSum[i][j] = getPrefixSum(prefixSum, i, j, map[i][j]);
            }
        }

        for (int i = 0; i < k; i++) {
            token = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(token.nextToken()) - 1;
            int y1 = Integer.parseInt(token.nextToken()) - 1;
            int x2 = Integer.parseInt(token.nextToken()) - 1;
            int y2 = Integer.parseInt(token.nextToken()) - 1;
            int[] result = computePrefixSum(prefixSum, x1, y1, x2, y2);
            for (int count : result) {
                sb.append(count).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int[] computePrefixSum(int[][][] prefix, int x1, int y1, int x2, int y2) {
        int[] result = Arrays.copyOf(prefix[x2][y2], 3);

        int[] top = x1 == 0 ? new int[] {0, 0, 0} : prefix[x1-1][y2];
        int[] left = y1 == 0 ? new int[] {0, 0, 0} : prefix[x2][y1-1];
        int[] common = x1 == 0 || y1 == 0 ? new int[] {0, 0, 0} : prefix[x1-1][y1-1];
        for (int i  = 0; i < 3; i++) {
            result[i] -= (top[i] + left[i] - common[i]);
        }
        return result;
    }

    static int[] getPrefixSum(int[][][] prefix, int r, int c, char ch) {
        int[] arr1 = r == 0 ? new int[] {0, 0, 0} : prefix[r-1][c];
        int[] arr2 = c == 0 ? new int[] {0, 0, 0} : prefix[r][c-1];
        int[] arr3 = r == 0 || c == 0 ? new int[] {0, 0, 0} : prefix[r-1][c-1];
        int[] curr = getPrefixSum(ch);
        return getPrefixSum(arr1, arr2, arr3, curr);
    }

    static int[] getPrefixSum(char ch) {
        int jungle = 0;
        int ocean = 0;
        int ice = 0;
        if (ch == 'J') {
            jungle += 1;
        } else if (ch == 'O') {
            ocean += 1;
        } else {
            ice += 1;
        }
        return new int[] {jungle, ocean, ice};
    }

    static int[] getPrefixSum(int[] arr1, int[] arr2, int[] arr3, int[] curr) {
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = arr1[i] + arr2[i] - arr3[i] + curr[i];
        }
        return result;
    }
}