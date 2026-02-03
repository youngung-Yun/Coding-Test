import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][][] prefix;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        // [0]: (0,0)이 검은 색일 때 올바른 색의 개수
        // [1]: (0,0)이 흰색일 때 올바른 색의 개수
        prefix = new int[n][m][2];
        for (int r = 0; r < n; r++) {
            String row = reader.readLine();
            for (int c = 0; c < m; c++) {
                char color = row.charAt(c);
                prefix[r][c] = createPrefix(r, c, color);
            }
        }

        int ans = n * m;
        for (int r = 0; r <= n - k; r++) {
            for (int c = 0; c <= m - k; c++) {
                int[] current = getPrefix(r, c, r + k - 1, c + k - 1);
                ans = Integer.min(ans, Integer.min(current[0], current[1]));
            }
        }
        System.out.println(ans);
    }

    static int[] createPrefix(int r, int c, char color) {
        int[] top = (r == 0) ? new int[] {0, 0} : prefix[r-1][c];
        int[] left = (c == 0) ? new int[] {0, 0} : prefix[r][c-1];
        int[] common = (r == 0 || c == 0) ? new int[] {0, 0} : prefix[r-1][c-1];
        // r + c 가 짝수면 (0,0)과 같은 색이어야 함. 홀수면 다른 색이어야 함
        int[] current = new int[2];
        if ((r + c) % 2 == 0) {
            current[0] = (color == 'B') ? 1 : 0;
            current[1] = (color == 'W') ? 1 : 0;
        } else {
            current[0] = (color != 'B') ? 1 : 0;
            current[1] = (color != 'W') ? 1 : 0;
        }

        int[] result = new int[2];
        for (int i = 0; i < 2; i++) {
            result[i] = top[i] + left[i] - common[i] + current[i];
        }
        return result;
    }

    static int[] getPrefix(int x1, int y1, int x2, int y2) {
        int[] current = Arrays.copyOf(prefix[x2][y2], 2);

        int[] top = (x1 == 0) ? new int[] {0, 0} : prefix[x1-1][y2];
        int[] left = (y1 == 0) ? new int[] {0, 0} : prefix[x2][y1-1];
        int[] common = (x1 == 0 || y1 == 0) ? new int[] {0, 0} : prefix[x1-1][y1-1];

        for (int i = 0; i < 2; i++) {
            current[i] = current[i] - top[i] - left[i] + common[i];
        }
        return current;
    }
}