import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] classrooms = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] prefixSum = new long[n];
        prefixSum[0] = classrooms[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + classrooms[i];
        }
        Arrays.sort(prefixSum);
        long result = 0;
        for (int i = 0; i < k; i++) {
            result += prefixSum[n-1-i];
        }
        System.out.println(result);
    }
}