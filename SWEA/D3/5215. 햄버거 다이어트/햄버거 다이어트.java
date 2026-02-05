import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int ans;
    static int[][] ingredients;
    static int n;
    static int limit;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            ans = 0;

            StringTokenizer token = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(token.nextToken());
            limit = Integer.parseInt(token.nextToken());

            ingredients = new int[n][2];
            for (int i = 0; i < n; i++) {
                token = new StringTokenizer(bf.readLine());
                int taste = Integer.parseInt(token.nextToken());
                int calorie = Integer.parseInt(token.nextToken());
                ingredients[i] = new int[] { taste, calorie };
            }

            dfs(0, 0, 0);

            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int taste, int calorie, int depth) {
        if (calorie > limit) {
            return;
        }
        ans = Integer.max(ans, taste);
        if (depth == n) {
            return;
        }
        // 그 재료를 쓰는 경우
        dfs(taste + ingredients[depth][0],
                calorie + ingredients[depth][1],
                depth + 1);
        // 안 쓰는 경우
        dfs(taste, calorie, depth + 1);
    }
}
