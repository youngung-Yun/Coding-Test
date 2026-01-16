import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // dp[i][k] = first[0:i]와 second[0:k]의 lcs 길이
        // i == 0 || k == 0이면 dp[i][k] = 0
        // first[i] == second[k]면: dp[i][k] = dp[i-1][k-1] + 1
        // first[i] != second[k]면: dp[i][k] = max(dp[i-1][k], dp[i][k-1])

        String firstString = br.readLine();
        String secondString = br.readLine();

        int[][] dp = new int[firstString.length()][secondString.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int answer = lcs(dp, firstString, secondString, firstString.length() - 1, secondString.length() - 1);

        System.out.println(answer);
    }

    private static int lcs(int[][] dp, String first, String second, int firstIndex, int secondIndex) {
        if (firstIndex < 0 || secondIndex < 0) {
            return 0;
        }

        if (dp[firstIndex][secondIndex] != -1) {
            return dp[firstIndex][secondIndex];
        }

        if (first.charAt(firstIndex) == second.charAt(secondIndex)) {
            dp[firstIndex][secondIndex] = lcs(dp, first, second, firstIndex - 1, secondIndex - 1) + 1;
        }
        else {
            dp[firstIndex][secondIndex] = Math.max(lcs(dp, first, second, firstIndex - 1, secondIndex), 
            lcs(dp, first, second, firstIndex, secondIndex - 1));
        }
        return dp[firstIndex][secondIndex];
    }
}