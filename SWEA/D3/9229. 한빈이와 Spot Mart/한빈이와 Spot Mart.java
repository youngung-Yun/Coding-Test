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
            int left = 0;
            for (int right = n - 1; right >= 1; right--) {
                if (left >= right) {
                    break;
                }
                int sum = arr[left] + arr[right];
                while (sum <= m && left < right) {
                    ans = Integer.max(ans, sum);
                    ++left;
                    sum = arr[left] + arr[right];
                }
            }
            sb.append('#').append(testCase).append(' ').append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
