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
            int[] indegrees = new int[n+1];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjacency.get(a).add(b);
                ++indegrees[b];
            }

            int w = Integer.parseInt(br.readLine());
            int[] elapsed = new int[n+1];
            Deque<Integer> queue = new ArrayDeque<>();
            // 진입 차수 0인 노드 큐에 넣기
            for (int i = 1; i <= n; i++) {
                if (indegrees[i] == 0) {
                    queue.offerLast(i);
                    elapsed[i] = times[i];
                }
            }
            while (!queue.isEmpty()) {
                int current = queue.removeLast();
                for (int dest : adjacency.get(current)) {
                    elapsed[dest] = Integer.max(elapsed[dest], elapsed[current] + times[dest]);
                    --indegrees[dest];
                    if (indegrees[dest] == 0) {
                        queue.offerLast(dest);
                    }
                }
            }
            sb.append(elapsed[w]).append('\n');
        }
        System.out.println(sb);
    }
}