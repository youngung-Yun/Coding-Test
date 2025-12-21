import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static long min = 9_999_999_999L;
    private static long max = 0L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inequalities = br.readLine().split(" ");

        boolean[] visited = new boolean[10];
        int[] numArray = new int[n + 1];
        for (int i = 0; i <= 9; i++) {
            visited[i] = true;
            numArray[0] = i;
            dfs(inequalities, numArray, visited, 0, n);
            visited[i] = false;
        }

        System.out.println(String.format("%010d", max).substring(9 - n));
        System.out.println(String.format("%010d", min).substring(9 - n));
    }

    private static void dfs(String[] inequalities, int[] numArray, boolean[] visited, int depth, int n) {
        if (depth == n) {
            long result = 0;
            for (int digit : numArray) {
                result = (result * 10) + digit;
            }
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }

            String sign = inequalities[depth];
            if (sign.equals("<")) {
                if (numArray[depth] < i) {
                    visited[i] = true;
                    numArray[depth + 1] = i;
                    dfs(inequalities, numArray, visited, depth + 1, n);
                    visited[i] = false;
                }
            } else {
                if (numArray[depth] > i) {
                    visited[i] = true;
                    numArray[depth + 1] = i;
                    dfs(inequalities, numArray, visited, depth + 1, n);
                    visited[i] = false;
                }
            }
        }
    }
}
