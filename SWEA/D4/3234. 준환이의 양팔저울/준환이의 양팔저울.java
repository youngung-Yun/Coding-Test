import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

class Solution {

    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            answer = 0;
            int n = Integer.parseInt(br.readLine());
            int[] weights = new int[n];
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                weights[i] = Integer.parseInt(token.nextToken());
            }
            dfs(weights, new boolean[n], 0, n, 0, 0);

            sb.append('#').append(testCase).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int[] array, boolean[] visited, int idx, int n, int left, int right) {
        if (idx == n && left >= right) {
            ++answer;
            return;
        }
        if (left < right) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(array, visited, idx + 1, n, left + array[i], right);
            dfs(array, visited, idx + 1, n, left, right + array[i]);
            visited[i] = false;
        }
    }
}