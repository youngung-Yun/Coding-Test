import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] times = new int[n+1];
        int[] indegreeCounts = new int[n+1];
        int[] maxIndegreeTimes = new int[n+1];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int task = 1; task <=n; task++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            times[task] = Integer.parseInt(stk.nextToken());
            int indegreeCount = Integer.parseInt(stk.nextToken());
            indegreeCounts[task] = indegreeCount;
            for (int i = 0; i < indegreeCount; i++) {
                adj.get(Integer.parseInt(stk.nextToken())).add(task);
            }
            if (indegreeCount == 0) {
                queue.offer(task);
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int currentTask = queue.poll();
            int needTime = maxIndegreeTimes[currentTask] + times[currentTask];
            ans = Integer.max(ans, needTime);

            for (int next : adj.get(currentTask)) {
                maxIndegreeTimes[next] = Integer.max(maxIndegreeTimes[next], needTime);

                if (--indegreeCounts[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(ans);
    }
}
