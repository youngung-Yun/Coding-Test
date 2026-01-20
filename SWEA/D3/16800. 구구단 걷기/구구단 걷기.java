import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            long n = Long.parseLong(br.readLine());
            long answer = n;
            for (long i = 1; i <= (long) Math.floor(Math.sqrt(n)); ++i) {
                if (n % i == 0) {
                    answer = Long.min(answer, -2 + i + (n / i));
                }
            }
            sb.append('#').append(testCase).append(' ').append(answer).append('\n');
        };
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}