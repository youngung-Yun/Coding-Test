import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static int[] dp = new int[100_000];



    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Arrays.fill(dp, -1);
        for (int i = 0; i < 10; i++) {
            dp[i] = 0;
        }

        for (int i = 10; i < 100_000; i++) {
            getDp(i);
        }

        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = Integer.parseInt(bf.readLine());
            int ans = dp[n];
            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    /*
     * 1. 나눌 수 있는 조합 구함
     * 2. 조합별 곱 구함
     * 3. 그 중 가장 큰 dp 값 + 1
     */
    static void getDp(int n) {
        getCombination(n, new ArrayList<>(), String.valueOf(n).length());
    }

    static void getCombination(int n, List<Integer> comb, int remainLength) {
        if (remainLength == 0) {
            if (comb.size() == 1) {
                return;
            }
            int multiply = getMultiply(n, comb);
            dp[n] = Integer.max(dp[n], dp[multiply] + 1);
            return;
        }

        for (int digit = 1; digit <= remainLength; digit++) {
            comb.add(digit);
            getCombination(n, comb, remainLength - digit);
            comb.remove(comb.size() - 1);
        }
    }

    static int getMultiply(int n, List<Integer> comb) {
        String str = String.valueOf(n);
        int start = 0;
        int multiply = 1;
        for (int end : comb) {
            multiply *= Integer.parseInt(str.substring(start, start + end));
            start += end;
        }
        return multiply;
    }
}
