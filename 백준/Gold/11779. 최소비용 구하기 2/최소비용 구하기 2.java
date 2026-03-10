import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] prev;
    static int[] cost;
    static List<List<int[]>> adj;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        prev = new int[n+1];
        cost = new int[n+1];
        Arrays.fill(cost, 1_000 * 100_000 + 1);
        adj = initAdj(n);


        for (int i = 0; i < m; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            adj.get(a).add(new int[] {b, c});
        }

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        findShortestPath(start);

        System.out.println(cost[end]);

        Deque<Integer> stack = traceback(end);
        System.out.println(stack.size());

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }
        System.out.println(sb);
    }

    private static void findShortestPath(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));
        pq.add(new int[] {start, 0});
        cost[start] = 0;
        prev[start] = start;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int node = now[0];
            int c = now[1];

            if (c > cost[node]) {
                continue;
            }

            for (int[] next : adj.get(node)) {
                if (cost[next[0]] > cost[node] + next[1]) {
                    cost[next[0]] = cost[node] + next[1];
                    pq.add(new int[] {next[0], cost[next[0]]});
                    prev[next[0]] = node;
                }
            }
        }
    }

    private static Deque<Integer> traceback(int node) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (; node != prev[node]; node = prev[node]) {
            stack.push(node);
        }
        stack.push(node);
        return stack;
    }

    private static List<List<int[]>> initAdj(int n) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        return adj;
    }
}