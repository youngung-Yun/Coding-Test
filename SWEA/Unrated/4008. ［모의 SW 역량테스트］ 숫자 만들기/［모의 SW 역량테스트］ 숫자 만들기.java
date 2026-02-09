import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int min;
    static int max;
    static int[] operators;
    static int[] operands;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            n = Integer.parseInt(bf.readLine());
            min = 100_000_000;
            max = -100_000_000;
            // +, -, *, /
            operators = new int[4];
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < 4; i++) {
                operators[i] = Integer.parseInt(stk.nextToken());
            }

            operands = new int[n];
            stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                int number = Integer.parseInt(stk.nextToken());
                operands[i] = number;

            }

            dfs(0, operands[0]);
            sb.append('#').append(testCase).append(' ')
                    .append(max - min).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int result) {
        if (depth == n - 1) {
            min = Integer.min(min, result);
            max = Integer.max(max, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) {
                continue;
            }
            --operators[i];
            if (i == 0) {
                dfs(depth + 1, result + operands[depth+1]);
            } else if (i == 1) {
                dfs(depth + 1, result - operands[depth+1]);
            } else if (i == 2) {
                dfs(depth + 1, result * operands[depth+1]);
            } else if (i == 3) {
                dfs(depth + 1, result / operands[depth+1]);
            }
            ++operators[i];
        }
    }
}
