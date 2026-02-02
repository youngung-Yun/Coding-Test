import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer token = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[][] prefixSum = new int[n][n];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(token.nextToken());
                if (j == 0) {
                    prefixSum[i][j] = number;
                } else {
                    prefixSum[i][j] = prefixSum[i][j-1] + number;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(reader.readLine());
            // to 0-based
            int x1 = Integer.parseInt(token.nextToken()) - 1;
            int y1 = Integer.parseInt(token.nextToken()) - 1;
            int x2 = Integer.parseInt(token.nextToken()) - 1;
            int y2 = Integer.parseInt(token.nextToken()) - 1;
            int sum = getSum(prefixSum, x1, y1, x2, y2);
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }

    static int getSum(int[][] prefix, int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int i = x1; i <= x2; i++) {
            if (y1 == 0) {
                sum += prefix[i][y2];
            } else {
                sum += prefix[i][y2] - prefix[i][y1-1];
            }
        }
        return sum;
    }
}
