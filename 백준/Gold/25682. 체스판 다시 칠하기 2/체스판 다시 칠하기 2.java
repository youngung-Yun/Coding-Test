import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] prefix;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        char startColor = ' ';
        // 검은 색 일때 잘못 칠해진 개수
        prefix = new int[n+1][m+1];
        for (int r = 1; r <= n; r++) {
            String row = reader.readLine();
            for (int c = 1; c <= m; c++) {
                char color = row.charAt(c-1);
                if (r == 1 && c == 1) {
                    startColor = color;
                }
                prefix[r][c] = findPrefix(r, c, color, startColor);
            }
        }

        int ans = k * k;
        for (int r = k; r <= n; r++) {
            for (int c = k; c <= m; c++) {
                int wrongCount = computePrefix(r, c, k);
                ans = Integer.min(ans, Integer.min(wrongCount, (k * k) - wrongCount));
            }
        }
        System.out.println(ans);
    }

    static int findPrefix(int x, int y, char color, char startColor) {
        int diff = 0;
        // 시작 색과 같아야 함
        if ((x + y) % 2 == 0) {
            diff = color != startColor ? 1 : 0;
        } else {
            // 시작 색과 달라야 함
            diff = color == startColor ? 1 : 0;
        }
        return prefix[x-1][y] + prefix[x][y-1] - prefix[x-1][y-1] + diff;
    }

    static int computePrefix(int x, int y, int k) {
        return prefix[x][y] - prefix[x-k][y] - prefix[x][y-k] + prefix[x-k][y-k];
    }
}