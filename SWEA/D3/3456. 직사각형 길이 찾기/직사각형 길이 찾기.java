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
            int result;
            int[] length = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (length[0] == length[1]) {
                result = length[2];
            } else if (length[0] == length[2]) {
                result = length[1];
            } else {
                result = length[0];
            }
            sb.append('#').append(t).append(' ').append(result).append('\n');
        }
        System.out.println(sb);
    }
}