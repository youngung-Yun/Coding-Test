import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static Set<Integer> buttons = new HashSet<>();
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int b = 0; b < 10; b++) {
            buttons.add(b);
        }

        n = Integer.parseInt(bf.readLine());
        ans = Math.abs(n - 100);

        int m = Integer.parseInt(bf.readLine());
        if (m > 0) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < m; i++) {
                buttons.remove(Integer.parseInt(stk.nextToken()));
            }
        }

        for (int b : buttons) {
            backtrack(b, 1);
        }

        System.out.println(ans);
    }

    static void backtrack(int curr, int depth) {
        if (curr > Integer.max(100, n * 2)) {
            return;
        }
        ans = Integer.min(ans, depth + Math.abs(curr - n));

        for (int b : buttons) {
            if (curr == 0 && b == 0) {
                continue;
            }
            backtrack((curr * 10) + b, depth + 1);
        }
    }
}