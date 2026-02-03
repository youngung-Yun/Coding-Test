import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int ans = 0;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < n; ++right) {
            sum += arr[right];
            while (sum > m && left <= right) {
                sum -= arr[left];
                ++left;
            }
            if (sum == m) {
                ++ans;
            }
        }
        System.out.println(ans);
    }
}
