import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            String pattern = stk.nextToken();
            int patternLength = pattern.length();
            String target = stk.nextToken();
            int targetLength = target.length();


            int[] patternCount = getCountArray(pattern);
            int[] prefixSum = getCountArray(target.substring(0, patternLength));

            int ans = 0;
            if (isAnagram(prefixSum, patternCount)) {
                ++ans;
            }
            int left = 0;
            for (int right = patternLength; right < targetLength; right++) {
                ++prefixSum[target.charAt(right) - 'a'];
                --prefixSum[target.charAt(left++) - 'a'];

                if (isAnagram(prefixSum, patternCount)) {
                    ++ans;
                }
            }

            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static int[] getCountArray(String word) {
        int[] array = new int[26];
        for (char ch : word.toCharArray()) {
            ++array[ch - 'a'];
        }
        return array;
    }

    private static boolean isAnagram(int[] pattern, int[] target) {
        for (int i = 0; i < 26; i++) {
            if (pattern[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
