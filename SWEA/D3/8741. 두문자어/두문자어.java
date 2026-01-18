import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            String[] input = br.readLine().split(" ");
            sb.append('#').append(testCase).append(' ');
            for (String word : input) {
                sb.append(Character.toUpperCase(word.charAt(0)));
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}