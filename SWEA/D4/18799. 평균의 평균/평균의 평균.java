import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    static double ans;

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            ans = 0.0;
            int n = Integer.parseInt(br.readLine());
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stk.nextToken());
            }

            for (int binary = 1; binary < (0b1 << n); binary++) {
                ans += getAverage(arr, binary, n);
            }

            ans /= Math.pow(2.0, n) - 1;

            sb.append('#').append(tc).append(' ')
                    .append(rtrim(String.format("%.20f", ans))).append('\n');
        }
        System.out.println(sb);
    }

    private static String rtrim(String number) {
        StringBuilder sb = new StringBuilder(number);
        while (sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static double getAverage(int[] arr, int binary, int n) {
        int count = Integer.bitCount(binary);
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            int mask = (0b1 << i);
            if ((binary & mask) != 0) {
                sum += arr[i];
            }
        }
        return sum / count;
    }
}