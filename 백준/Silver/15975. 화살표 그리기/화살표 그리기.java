import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int MAX = 1_000_000_001;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[][] dots = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int coord = Integer.parseInt(stk.nextToken());
            int color = Integer.parseInt(stk.nextToken());
            dots[i][0] = coord;
            dots[i][1] = color;
        }

        // 색깔 순, 좌표 순 정렬
        Arrays.sort(dots, (d1, d2) -> {
            if (d1[1] == d2[1]) {
                return Integer.compare(d1[0], d2[0]);
            }
            return Integer.compare(d1[1], d2[1]);
        });

        long ans = 0L;
        for (int i = 0; i < n; i++) {
            int[] curr = dots[i];
            int left = 0;
            if (i-1 < 0 || dots[i-1][1] != curr[1]) {
                left = MAX;
            } else {
                left = Math.abs(curr[0] - dots[i-1][0]);
            }
            int right = 0;
            if (i + 1 >= n || dots[i+1][1] != curr[1]) {
                right = MAX;
            } else {
                right = Math.abs(curr[0] - dots[i+1][0]);
            }

            if (left == MAX && right == MAX) {
                continue;
            }
            ans += Integer.min(left, right);
        }

        System.out.println(ans);
    }
}