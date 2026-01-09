import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] prefixSum = new long[n+1];
        for (int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i] + array[i];
        }
        long result = 0L;
        for (int i = m; i <= n; i++) {
            result = Long.max(result, prefixSum[i] - prefixSum[i - m]);
        }
        System.out.println(result);
    }
}