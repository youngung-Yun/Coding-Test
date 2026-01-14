import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int result = 10_000_001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                graph[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(new boolean[n], new int [n], 0, n);
        System.out.println(result);
    }

    static void dfs(boolean[] visited, int[] array, int depth, int n) {
        if (depth == n - 1) {
            array[depth] = 0;
            int start = 0;
            int cost = 0;
            for (int d : array) {
                if (graph[start][d] == 0) {
                    return;
                }
                cost += graph[start][d];
                start = d;
            }
            result = Integer.min(result, cost);
            return;
        }

        for (int i = 1; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            array[depth] = i;
            dfs(visited, array, depth + 1, n);
            visited[i] = false;
        }
    }
}