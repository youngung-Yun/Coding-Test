import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int[] seq = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int left = 0;
        int oddCount = seq[0] % 2 == 0 ? 0 : 1;
        int ans = oddCount == 0 ? 1 : 0;

        for (int right = 1; right < n; right++) {
            int number = seq[right];
            if (number % 2 == 1) {
                ++oddCount;
            }

            if (oddCount > k) {
                while (seq[left] % 2 == 0) {
                    ++left;
                }

                if (left < right) {
                    ++left;
                }
                --oddCount;
            }

            ans = Integer.max(ans, (right - left + 1) - oddCount);
        }

        System.out.println(ans);
    }
}