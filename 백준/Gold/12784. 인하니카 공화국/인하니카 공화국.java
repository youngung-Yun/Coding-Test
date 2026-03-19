import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int MAX = 1_000 * 1_000;
    static List<List<int[]>> adj;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            int m = Integer.parseInt(stk.nextToken());
            for (int i = 0; i < m; i++) {
                stk = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                int c = Integer.parseInt(stk.nextToken());
                adj.get(a).add(new int[] {b, c});
                adj.get(b).add(new int[] {a, c});
            }

            int ans = getDp(1, 1);
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    // 그 자식 노드를 끊는다 : 비용 child[1]
    // 그 자식 노드를 끊지 않는다 : 비용 getDp(child[0])
    private static int getDp(int root, int parent) {
        if (root != 1 && adj.get(root).size() == 1) {
            return MAX;
        }
        int result = 0;
        for (int[] child : adj.get(root)) {
            if (child[0] == parent) {
                continue;
            }
            result += Integer.min(child[1], getDp(child[0], root));
        }
        return result;
    }
}