import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            String standingOvation = br.readLine();
            int answer = 0;
            int curr = 0;
            for (int i = 0; i < standingOvation.length(); i++) {
                if (curr < i) {
                    answer += (i - curr);
                    curr = i;
                }
                int n = Character.getNumericValue(standingOvation.charAt(i));
                curr += n;
            }
            sb.append('#').append(testCase).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }
}