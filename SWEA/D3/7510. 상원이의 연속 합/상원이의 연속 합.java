import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;

            int left = 0;
            int right = 0;
            int sum = 0;
            while (right <= n) {
                sum += right;
                while (left < right && sum > n) {
                    sum -= left;
                    ++left;
                }
                if (sum == n) {
                    ++count;
                }
                ++right;
            }

            sb.append('#').append(testCase).append(' ').append(count).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}