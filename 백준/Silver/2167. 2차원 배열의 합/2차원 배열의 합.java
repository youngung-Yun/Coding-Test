import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        int[][] prefixSums = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int number = Integer.parseInt(row[j]);
                if (j == 0) {
                    prefixSums[i][j] = number;
                } else {
                    prefixSums[i][j] = prefixSums[i][j - 1] + number;
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            String[] point = br.readLine().split(" ");
            int ax = Integer.parseInt(point[0]) - 1;
            int ay = Integer.parseInt(point[1]) - 1;
            int bx = Integer.parseInt(point[2]) - 1;
            int by = Integer.parseInt(point[3]) - 1;
            int sum = 0;
            for (int j = ax; j <= bx; j++) {
                if (ay == 0) {
                    sum += prefixSums[j][by];
                } else {
                    sum += (prefixSums[j][by] - prefixSums[j][ay - 1]);
                }
            }

            sb.append(sum).append('\n');
        }

        System.out.println(sb.toString());
    }
}