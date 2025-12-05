import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] prefixSum = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (i == 0) {
                prefixSum[i] = number;
            } else {
                prefixSum[i] = prefixSum[i - 1] + number;
            }
        }
        int max = prefixSum[k - 1];
        for (int i = k; i < n; i++) {
            max = Math.max(max, prefixSum[i] - prefixSum[i - k]);
        }

        System.out.println(max);
    }
}