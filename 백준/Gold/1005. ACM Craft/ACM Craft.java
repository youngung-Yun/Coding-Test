import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] times = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }
            List<List<Integer>> adjacency = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adjacency.add(new ArrayList<>());
            }

            // 자신의 선행 노드 넣음
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjacency.get(b).add(a);
            }

            int w = Integer.parseInt(br.readLine());

            int[] elapsed = new int[n+1];
            Arrays.fill(elapsed, -1);

            dp(adjacency, elapsed, times, w);
            sb.append(elapsed[w]).append('\n');

        }
        System.out.println(sb);
    }

    static void dp(List<List<Integer>> adjacency, int[] elapsed, int[] times, int current) {
        int max = 0;
        for (int prev : adjacency.get(current)) {
            if (elapsed[prev] == -1) {
                dp(adjacency, elapsed, times, prev);
            }
            max = Integer.max(max, elapsed[prev]);
        }
        elapsed[current] = max + times[current];
    }
}