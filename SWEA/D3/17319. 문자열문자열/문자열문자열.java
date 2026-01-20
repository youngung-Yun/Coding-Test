import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            String word = br.readLine();
            boolean canRepeated = true;
            if (n % 2 == 1) {
                canRepeated = false;
            } else {
                int half = n / 2;
                if (!word.substring(0, half).equals(word.substring(half, n))) {
                    canRepeated = false;
                }
            }

            sb.append('#').append(testCase).append(' ').append(canRepeated ? "Yes" : "No").append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }
}