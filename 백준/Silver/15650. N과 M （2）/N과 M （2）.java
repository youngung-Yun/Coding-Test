import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dfs(new boolean[n + 1], new int[m], 0, 1, n, m);
        System.out.println(sb.toString());
    }

    private static void dfs(boolean[] visited, int[] curr, int depth, int currIndex, int n, int m) {
        if (depth == m) {
            for (int number : curr) {
                sb.append(number).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = currIndex; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            curr[depth] = i;
            dfs(visited, curr, depth + 1, i + 1, n, m);
            visited[i] = false;

        }
    }
}