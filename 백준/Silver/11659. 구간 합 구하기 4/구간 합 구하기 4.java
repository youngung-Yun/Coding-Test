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

        int[] prefixSum = new int[n];
        token = new StringTokenizer(reader.readLine());
        for (int i = 0 ; i < n; i++) {
            int e = Integer.parseInt(token.nextToken());
            if (i == 0) {
                prefixSum[i] = e;
            } else {
                prefixSum[i] = prefixSum[i-1] + e;
            }
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(reader.readLine());
            // to 0-based
            int start = Integer.parseInt(token.nextToken()) - 1;
            int end = Integer.parseInt(token.nextToken()) - 1;
            if (start == 0) {
                sb.append(prefixSum[end]).append('\n');
            } else {
                sb.append(prefixSum[end] - prefixSum[start - 1]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
