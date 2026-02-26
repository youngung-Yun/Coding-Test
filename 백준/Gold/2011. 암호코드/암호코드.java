import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    final static int MOD = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String cipher = bf.readLine();

        if (cipher.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        // dp[k] : k번쨰 숫자짜리 읽었을 때 나올 수 있는 경우의 수
        // dp[k] = dp[k-1](cipher[k] = '0'이면 0) + dp[k-2] (뒤 두자리가 범위 내이면)
        int[] dp = new int[cipher.length()];
        dp[0] = 1;
        for (int i = 1; i < cipher.length(); i++) {
            int readAlone = cipher.charAt(i) == '0' ? 0 : dp[i-1];
            int readDual = 0;
            if (cipher.charAt(i - 1) != '0' && inRange(getSubnumber(cipher, i))) {
                if (i == 1) {
                    readDual = 1;
                } else {
                    readDual = dp[i-2];
                }
            }
            dp[i] = (readAlone + readDual) % MOD;
        }
        System.out.println(dp[cipher.length()-1]);
    }

    private static boolean inRange(int n) {
        return n > 0 && n <= 26;
    }

    private static int getSubnumber(String str, int idx) {
        return Integer.parseInt(str.substring(idx - 1, idx + 1));
    }
}
