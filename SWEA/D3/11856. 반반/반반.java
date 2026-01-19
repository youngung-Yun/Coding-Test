import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] months = new int[] {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] days = new int[] {4, 5, 6, 0, 1, 2, 3};

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            char[] array = br.readLine().toCharArray();
            Arrays.sort(array);
            boolean isHalf = array[0] == array[1] && array[1] != array[2] && array[2] == array[3];

            sb.append('#').append(testCase).append(' ').append(isHalf ? "Yes" : "No").append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}