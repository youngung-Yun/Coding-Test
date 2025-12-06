import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            int[] set = new int[k];
            for (int i = 0; i < k; i++) {
                set[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(set);

            dfs(set, k, new boolean[50], 0, new int[6], 0);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int[] set, int k, boolean[] visited, int depth, int[] array, int curr) {
        if (depth == 6) {
            for (int n : array) {
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = curr; i < k; i++) {
            int number = set[i];
            if (visited[number]) {
                continue;
            }
            array[depth] = number;
            visited[number] = true;
            dfs(set, k, visited, depth + 1, array, i + 1);
            visited[number]  = false;
        }
    }
}