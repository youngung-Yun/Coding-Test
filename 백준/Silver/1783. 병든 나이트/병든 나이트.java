import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int ans = 0;

        if (n == 1) {
            ans = 1;
        } else if (n == 2) {
            ans = Integer.min(((m - 1) / 2) + 1, 4);
        } else {
            if (m <= 6) {
                ans = Integer.min(m, 4);
            } else {
                ans = m - 2;
            }
        }

        System.out.println(ans);
    }

}