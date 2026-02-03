import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());

            int[] arr = new int[n];
            token = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }

            Arrays.sort(arr);

            int ans = -1;
            for (int i = n - 1; i >= 1; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    int sum = arr[i] + arr[j];
                    if (sum <= m) {
                        ans = Integer.max(ans, sum);
                        break;
                    }
                }
            }
            sb.append('#').append(testCase).append(' ').append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
