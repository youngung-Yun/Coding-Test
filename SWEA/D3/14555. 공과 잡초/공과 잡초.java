import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            String grassland = br.readLine();
            int ballCount = 0;
            for (int i = 0; i < grassland.length(); i++) {
                if (grassland.charAt(i) == '(') {
                    ++ballCount;
                }
                if (grassland.charAt(i) == ')' && i >= 1 && grassland.charAt(i-1) != '(') {
                    ++ballCount;
                }
            }
            sb.append('#').append(testCase).append(' ').append(ballCount).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}