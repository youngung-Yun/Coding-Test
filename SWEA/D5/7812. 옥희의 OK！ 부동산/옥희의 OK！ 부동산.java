import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());

            int n = Integer.parseInt(stk.nextToken());
            long m = Long.parseLong(stk.nextToken());

            long[] arr = new long[n];
            stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(stk.nextToken());
            }

            long ans = 0L;
            long sum = 0L;
            int left = 0;
            for (int right = 0; right < n; right++) {
                sum += arr[right];
                while (left < right && sum > m) {
                    sum -= arr[left];
                    ++left;
                }
                if (sum == m) {
                    ++ans;
                }
            }

            sb.append('#').append(tc).append(' ')
                    .append(ans).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}