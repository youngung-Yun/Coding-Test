import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int d = Integer.parseInt(br.readLine());
            int answer;
            if (d < 100) {
                answer = 0;
            } else if (d < 1_000) {
                answer = 1;
            } else if (d < 10_000) {
                answer = 2;
            } else if (d < 100_000) {
                answer = 3;
            } else if (d < 100_000_0) {
                answer = 4;
            } else {
                answer = 5;
            }
            sb.append('#').append(testCase).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

}