import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            boolean f = false;
            for (int i = 1; i <= 9; i++) {
                if (n % i == 0 && n / i <= 9) {
                    f = true;
                    break;
                }
            }
            sb.append('#').append(testCase).append(' ').append(f ? "Yes" : "No").append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}