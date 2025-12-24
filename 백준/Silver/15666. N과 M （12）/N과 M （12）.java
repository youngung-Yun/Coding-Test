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

        dfs(array, new int[m], 0, m, n, 0);
        System.out.println(sb.toString());
    }

    private static void dfs(int[] array, int[] sequence, int depth, int limit, int length, int index) {
        if (depth == limit) {
            StringBuilder tmp = new StringBuilder();
            for (int e : sequence) {
                tmp.append(e).append(' ');
            }
            if (set.contains(tmp.toString())) {
                return;
            }
            set.add(tmp.toString());
            sb.append(tmp.toString()).append('\n');
            return;
        }
        for (int i = index; i < length; i++) {
            sequence[depth] = array[i];
            dfs(array, sequence,depth + 1, limit, length, i);
        }
    }
}
