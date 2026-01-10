import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dfs(new boolean[n+1], 0, n, new int[n]);
        System.out.println(sb);
    }


    static void dfs(boolean[] visited, int depth, int n, int[] array) {
        if (depth == n) {
            for (int e : array) {
                sb.append(e).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            array[depth] = i;
            dfs(visited, depth + 1, n, array);
            visited[i] = false;
        }
    }
}
