import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            int average = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).map(n -> Integer.max(n, 40)).sum() / 5;
            sb.append('#').append(t).append(' ').append(average).append('\n');
        }
        System.out.println(sb);
    }
}