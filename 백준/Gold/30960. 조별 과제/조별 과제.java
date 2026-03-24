import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] num = new int[n];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(num);

        int[] evenSum = new int[n];
        int[] oddSum = new int[n];

        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                evenSum[i] = evenSum[i-1];
                oddSum[i] = oddSum[i-1] + (num[i] - num[i-1]);
            } else {
                oddSum[i] = oddSum[i-1];
                evenSum[i] = evenSum[i-1] + (num[i] - num[i-1]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 2; i < n; i += 2) {
            int three = num[i] - num[i-2];
            int left = evenSum[i-2];
            int right = oddSum[n-1] - oddSum[i];

            ans = Integer.min(ans, left + three + right);
        }

        System.out.println(ans);
    }
}