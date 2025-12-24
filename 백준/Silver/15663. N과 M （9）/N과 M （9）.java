import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private final static Set<String> set = new HashSet<>();
    private final static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);

        dfs(array, new int[m], new boolean[n], 0, m, n);
        System.out.println(sb.toString());
    }

    private static void dfs(int[] array, int[] sequence, boolean[] visited, int depth, int limit, int length) {
        if (depth == limit) {
            StringBuilder tmp = new StringBuilder();
            for (int n : sequence) {
                tmp.append(n).append(' ');
            }
            if (set.contains(tmp.toString())) {
                return;
            }
            set.add(tmp.toString());
            sb.append(tmp.toString()).append('\n');
            return;
        }
        for (int i = 0; i < length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            sequence[depth] = array[i];
            dfs(array, sequence, visited, depth + 1, limit, length);
            visited[i] = false;
        }
    }
}
