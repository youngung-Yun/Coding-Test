import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int id = 1;
    static int[] dfsId;
    static boolean[] visited;
    static boolean[] finished;
    static List<List<Integer>> adj;
    static Deque<Integer> stack = new ArrayDeque<>();
    static List<List<Integer>> components = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int v = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());

        dfsId = new int[v+1];
        visited = new boolean[v+1];
        finished = new boolean[v+1];

        adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            stk = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            adj.get(from).add(to);
        }

        for (int node = 1; node <= v; node++) {
            if (dfsId[node] == 0) {
                dfs(node);
            }
        }

        components.sort((c1, c2) -> Integer.compare(c1.get(0), c2.get(0)));

        StringBuilder sb = new StringBuilder();
        sb.append(components.size()).append('\n');
        for (List<Integer> scc : components) {
            for (int node : scc) {
                sb.append(node).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int dfs(int current) {
        stack.push(current);
        visited[current] = true;
        dfsId[current] = id;
        id++;

        int minId = dfsId[current];
        for (int next : adj.get(current)) {
            // 이미 처리 완료된 노드
            if (visited[next] && finished[next]) {
                continue;
            // 사이클임
            } else if (visited[next] && !finished[next]) {
                minId = Integer.min(minId, dfsId[next]);
            } else {
                minId = Integer.min(minId, dfs(next));
            }
        }

        if (minId == dfsId[current]) {
            List<Integer> scc = new ArrayList<>();
            while (stack.peek() != current) {
                int node = stack.pop();
                finished[node] = true;
                scc.add(node);
            }
            finished[current] = true;
            scc.add(stack.pop());
            scc.sort(Comparator.naturalOrder());
            scc.add(-1);
            components.add(scc);
        }

        return minId;
    }
}

