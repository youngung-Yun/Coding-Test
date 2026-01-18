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
            String game = br.readLine();
            int loseCount = 0;
            for (char result : game.toCharArray()) {
                if (result == 'x') {
                    ++loseCount;
                }
            }
            sb.append('#').append(testCase).append(' ').append(loseCount < 8 ? "YES" : "NO").append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}