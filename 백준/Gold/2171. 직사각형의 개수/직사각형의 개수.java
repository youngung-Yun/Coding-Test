import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        // [x, y]
        int[][] dots = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            dots[i][0] = x;
            dots[i][1] = y;
        }

        /*
         * 1. x 좌표 기준 정렬
         * 2. x 좌표가 같은 점끼리 연결해 선 만듦
         * 3. 선을 y좌표 기준 정렬
         * 4. 나와 y좌표가 같은 선이 있는지 확인
         */

        // 1.
        Arrays.sort(dots, (d1, d2) -> {
            if (d1[0] == d2[0]) {
                return Integer.compare(d1[1], d2[1]);
            }
            return Integer.compare(d1[0], d2[0]);
        });

        // [x, y1, y2]
        List<int[]> lines = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int[] dot = dots[i];
            int low = i + 1;
            int high = n;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (dots[mid][0] <= dot[0]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            for (int k = i + 1; k < low; k++) {
                lines.add(new int[] {dot[0], dot[1], dots[k][1]});
            }
        }

        lines.sort((l1, l2) -> {
            if (l1[1] == l2[1]) {
                if (l1[2] == l2[2]) {
                    return Integer.compare(l1[0], l2[0]);
                }
                return Integer.compare(l1[2], l2[2]);
            }
            return Integer.compare(l1[1], l2[1]);
        });

        long ans = 0L;
        for (int i = 0; i < lines.size() - 1; i++) {
            int[] line = lines.get(i);
            int low = i + 1;
            int high = lines.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                int[] other = lines.get(mid);
                if (line[1] < other[1] || (line[1] == other[1] && line[2] < other[2])) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            ans += (low - i - 1);
        }
        System.out.println(ans);
    }
}