import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            int ans = 0;

            StringTokenizer token = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(token.nextToken());
            int limit = Integer.parseInt(token.nextToken());

            int[][] ingredients = new int[n][2];
            for (int i = 0; i < n; i++) {
                token = new StringTokenizer(bf.readLine());
                int taste = Integer.parseInt(token.nextToken());
                int calorie = Integer.parseInt(token.nextToken());
                ingredients[i] = new int[] { taste, calorie };
            }

            for (int subset = 0; subset < 0b1 << n; subset++) {
                int taste = 0;
                int calorie = 0;
                for (int i = 0; i < n; i++) {
                    int mask = 0b1 << i;
                    if ((subset & mask) > 0) {
                        taste += ingredients[i][0];
                        calorie += ingredients[i][1];
                    }
                }
                if (calorie > limit) {
                    continue;
                }
                ans = Integer.max(ans, taste);
            }

            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
