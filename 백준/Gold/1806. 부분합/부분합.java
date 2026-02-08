import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int s = Integer.parseInt(stk.nextToken());

        int[] sequence = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(stk.nextToken());
        }

        int left = 0;
        int sum = 0;
        int ans = n;
        boolean canMake = false;
        for (int right = 0; right < n; ++right) {
            sum += sequence[right];
            while (left < right && sum - sequence[left] >= s) {
                sum -= sequence[left];
                ++left;
            }
            if (sum >= s) {
                canMake = true;
                ans = Integer.min(ans, (right - left + 1));
            }
        }
        System.out.println(canMake ? ans : 0);
    }
}