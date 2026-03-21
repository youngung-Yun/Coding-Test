import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int start = Integer.parseInt(stk.nextToken());

        int[] diffs = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(start - Integer.parseInt(stk.nextToken()));
        }

        int ans = diffs[0];
        for (int i = 1; i < n; i++) {
            ans = getGcd(Integer.max(ans, diffs[i]), Integer.min(ans, diffs[i]));
        }
        System.out.println(ans);
    }

    static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }
}