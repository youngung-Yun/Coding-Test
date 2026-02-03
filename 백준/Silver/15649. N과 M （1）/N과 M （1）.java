import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        dfs(new int[m], 0, new boolean[n+1]);
        System.out.println(sb);
    }

    static void dfs(int[] tmp, int depth, boolean[] visited) {
        if (depth == m) {
            for (int e : tmp) {
                sb.append(e).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            tmp[depth] = i;
            visited[i] = true;
            dfs(tmp, depth + 1, visited);
            visited[i] = false;
        }
    }
}
