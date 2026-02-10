import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int[] fees;
    static int[] plan;
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            fees = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            plan = new int[13];
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int i = 1; i <= 12; i++) {
                plan[i] = Integer.parseInt(stk.nextToken());
            }
            min = fees[3];

            dfs(1, 0);

            sb.append('#').append(testCase).append(' ')
                    .append(min).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int month, int sum) {
        if (sum >= min) {
            return;
        }
        if (month > 12) {
            min = Integer.min(min, sum);
            return;
        }

        // 1일 이용권
        dfs(month + 1, sum + (fees[0] * plan[month]));
        // 1달 이용권
        dfs(month + 1, sum + fees[1]);
        // 3달 이용권
        dfs(month + 3, sum + fees[2]);
    }
}
