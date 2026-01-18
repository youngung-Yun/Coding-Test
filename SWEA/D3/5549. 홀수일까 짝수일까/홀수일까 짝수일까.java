import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            String n = br.readLine();
            int digit = Character.getNumericValue(n.charAt(n.length() - 1));
            sb.append('#').append(testCase).append(' ')
                    .append(digit % 2 == 0 ? "Even" : "Odd").append('\n');
        }
        System.out.println(sb);
    }
}