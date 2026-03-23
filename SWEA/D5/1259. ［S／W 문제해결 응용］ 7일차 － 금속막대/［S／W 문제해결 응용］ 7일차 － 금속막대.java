import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static List<Integer> ans;
    static int n;
    static int[][] volts;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            ans = new ArrayList<>();
            n = Integer.parseInt(bf.readLine());
            volts = new int[n][2];
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                int male = Integer.parseInt(stk.nextToken());
                int female = Integer.parseInt(stk.nextToken());
                volts[i] = new int[] { male, female };
            }

            visited = new boolean[n];
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                visited[i] = true;
                curr.add(i);
                backtrack(volts[i][1], curr);
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }

            sb.append('#').append(tc).append(' ');
            for (int idx : ans) {
                sb.append(volts[idx][0]).append(' ').append(volts[idx][1]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void backtrack(int female, List<Integer> curr) {
        if (ans.size() < curr.size()) {
            ans = new ArrayList<>(curr);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            if (female != volts[i][0]) {
                continue;
            }

            visited[i] = true;
            curr.add(i);
            backtrack(volts[i][1], curr);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}