import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    final static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] count;
    static int[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        count = new int[10_001];
        selected = new int[10_001];

        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(stk.nextToken());
            ++count[number];
        }

        dfs(0, 1);

        System.out.println(sb);
    }

    private static void dfs(int depth, int curr) {
        if (depth == m) {
            for (int i = 1; i <= 10_000; i++) {
                int count = 0;
                while (count < selected[i]) {
                    sb.append(i).append(' ');
                    ++count;
                }
            }
            sb.append('\n');
            return;
        }

        for (int i = curr; i <= 10_000; i++) {
            if (count[i] <= selected[i]) {
                continue;
            }
            ++selected[i];
            dfs(depth + 1, i);
            --selected[i];
        }
    }
}