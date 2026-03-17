import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int row = Integer.parseInt(stk.nextToken());
        int col = Integer.parseInt(stk.nextToken());
        int paper = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        int maxCol = 0;
        int[][] point = new int[n][2];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            maxCol = Integer.max(maxCol, c);
            // [c, r]
            point[i][0] = c;
            point[i][1] = r;
        }

        Arrays.sort(point, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p1[1], p2[1]);
            }
            return Integer.compare(p1[0], p2[0]);
        });

        int low = 1;
        int high = 1_000_001;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // mid 크기의 색종이로 잘못 그린 모든 칸을 가리는데 paper장 이하로 필요한가?
            if (canHideAll(point, mid, paper)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }

    private static boolean canHideAll(int[][] point, int size, int limit) {
        int count = 0;
        int colEnd = 0;
        for (int[] p : point) {
            int c = p[0];
            int r = p[1];

            if (r > size) {
                return false;
            }

            if (c > colEnd) {
                ++count;
                colEnd = c + size - 1;
            }
        }

        return count <= limit;
    }
}