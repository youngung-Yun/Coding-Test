import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(bf.readLine());
        for (int t = 0;  t < testcase; t++) {

            List<List<Integer>> adjacency = new ArrayList<>();
            StringTokenizer tokenizer = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(tokenizer.nextToken());
            for (int i = 0; i <= v; i++) {
                adjacency.add(new ArrayList<>());
            }

            int e = Integer.parseInt(tokenizer.nextToken());
            for (int i = 0; i < e; i++) {
                tokenizer = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());
                adjacency.get(a).add(b);
                adjacency.get(b).add(a);
            }

            int[] visited = new int[v+1];
            Arrays.fill(visited, -1);

            boolean isBipartiteGraph = true;
            for (int vertex = 1; vertex <= v; vertex++) {
                if (visited[vertex] == -1 && !checkBipartiteGraph(visited, vertex, adjacency)) {
                    isBipartiteGraph = false;
                    break;
                }
            }
            sb.append(isBipartiteGraph ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);
    }

    static boolean checkBipartiteGraph(int[] visited, int start, List<List<Integer>> adjacency) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.remove();

            for (int next : adjacency.get(current)) {
                if (visited[current] == visited[next]) {
                    return false;
                } else if (visited[next] == -1) {
                    visited[next] = (visited[current] + 1) % 2;
                    queue.offer(next);
                }
            }
        }
        return true;
    }
}