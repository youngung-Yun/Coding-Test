import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] sumMatrix = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= n; k++) {
                int element = Integer.parseInt(st.nextToken());
                sumMatrix[i][k] = sumMatrix[i][k - 1] + element;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            long sum = 0L;
            for (int x = x1; x <= x2; x++) {
                sum += (sumMatrix[x][y2] - sumMatrix[x][y1 - 1]);
            }

            sb.append(sum).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}