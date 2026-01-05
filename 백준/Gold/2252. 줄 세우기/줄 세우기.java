import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] indegrees = new int[n+1];
        List<List<Integer>> outdegrees = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            outdegrees.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int indegree = Integer.parseInt(st.nextToken());
            int outdegree = Integer.parseInt(st.nextToken());
            ++indegrees[outdegree];
            outdegrees.get(indegree).add(outdegree);
        }
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                queue.offerLast(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            sb.append(curr).append(' ');
            for (int outdegree : outdegrees.get(curr)) {
                --indegrees[outdegree];
                if (indegrees[outdegree] == 0) {
                    queue.offerLast(outdegree);
                }
            }
        }
        System.out.println(sb);
    }
}
