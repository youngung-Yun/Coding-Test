import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int[] kits;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        kits = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            kits[i] = Integer.parseInt(stk.nextToken());
        }

        backtrack(500, new boolean[n], 0);

        System.out.println(ans);
    }

    static void backtrack(int curr, boolean[] visited, int depth) {
        if (depth == n) {
            ++ans;
            return;
        }

        curr -= k;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            if (curr + kits[i] < 500) {
                continue;
            }
            visited[i] = true;
            backtrack(curr + kits[i], visited, depth + 1);
            visited[i] = false;
        }
    }
}