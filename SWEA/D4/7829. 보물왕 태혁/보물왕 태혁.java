import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testcase = 1; testcase <= t; ++testcase) {
            int n = Integer.parseInt(bf.readLine());
            int[] array = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int min = array[0];
            int max = array[0];
            for (int number : array) {
                min = Integer.min(min, number);
                max = Integer.max(max, number);
            }
            int ans = min * max;
            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

}