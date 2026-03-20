import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] progress;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        progress = new int[6];
        for (int r = 0; r < 2; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < 3; c++) {
                progress[3*r+c] = Integer.parseInt(stk.nextToken());
            }
        }

        dfs(-1, 0, 0, n);

        System.out.println(ans);
    }

    private static void dfs(int prev, int sum, int depth, int n) {
        if (depth == n) {
            ans += sum >= m ? 1 : 0;
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (prev == -1 || prev % 3 != i % 3) {
                dfs(i, sum + progress[i], depth + 1, n);
            } else {
                dfs(i, sum + (progress[i] / 2), depth + 1, n);
            }
        }
    }
}