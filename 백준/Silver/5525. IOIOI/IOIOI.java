import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
         * 1. dp로 각 문자가 몇 번째 연속된 문자열인지 저장
         * 2. dp 순회하며 dp[k] == 2n + 1이면 result 1 증가, k += 2
         */
        int n = Integer.parseInt(br.readLine());
        int length = 2 * n + 1;
        int m = Integer.parseInt(br.readLine());
        String word = br.readLine();

        int[] dp = new int[m];
        dp[0] = word.charAt(0) == 'I' ? 1 : 0;
        for (int i = 1; i < m; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                dp[i] = word.charAt(i) == 'I' ? 1 : 0;
                continue;
            } else {
                dp[i] = dp[i-1] + 1;
            }
        }
        int count = 0;
        int index = 0;
        while (index < m) {
            if (length > dp[index]) {
                ++index;
                continue;
            }
            ++count;
            index += 2;
        }

        System.out.println(count);
    }
}