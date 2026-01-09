import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] prefixSum = new long[n];
        prefixSum[0] = array[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + array[i];
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += array[i] * (prefixSum[n-1] - prefixSum[i]);
        }
        System.out.println(result);
    }
}