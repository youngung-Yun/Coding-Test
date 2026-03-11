import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> adj;
    static boolean[] checked; // 각 DFS마다 해당 작업이 점유되었는지
    static int[] managed; // 해당 작업을 담당하는 직원

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        checked = new boolean[m+1];
        managed = new int[m+1];

        adj = initAdj(n);

        for (int clerk = 1; clerk <= n; clerk++) {
            stk = new StringTokenizer(bf.readLine());
            int count = Integer.parseInt(stk.nextToken());
            for (int i = 0; i < count; i++) {
                int task = Integer.parseInt(stk.nextToken());
                adj.get(clerk).add(task);
            }
        }

        int ans = 0;
        for (int clerk = 1; clerk <= n; clerk++) {
            Arrays.fill(checked, false);
            if (dfs(clerk)) {
                ++ans;
            }
            if (dfs(clerk)) {
                ++ans;
            }
        }

        System.out.println(ans);
    }

    private static boolean dfs(int x) {
        for (int task : adj.get(x)) {
            if (checked[task]) {
                continue;
            }

            checked[task] = true;
            // 내가 고른 작업이 점유되지 않았거나 다른 사람이 작업을 옮겨줄 수 있으면
            if (managed[task] == 0 || (dfs(managed[task]))) {
                managed[task] = x;

                // 내가 점유한 첫 번째 작업만 방문처리
                Arrays.fill(checked, false);
                checked[task] = true;

                return true;
            }
        }
        return false;
    }

    private static List<List<Integer>> initAdj(int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        return adj;
    }
}