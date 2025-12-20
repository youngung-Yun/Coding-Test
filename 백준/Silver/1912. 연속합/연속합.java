import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        /*
         * dp[i - 1] + array[i] > array[i]: 기존 수열에 array[i] 추가
         * dp[i - 1] + array[i] < array[i]: 기존 수열 버리고 array[i]부터 시작
         */

        int n = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split( " ")).mapToInt(Integer::parseInt).toArray();

        long max = array[0];
        int index = 0;
        long[] dp = new long[n];
        dp[0] = array[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        System.out.println(dp[index]);
    }
}
