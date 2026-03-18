import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(bf.readLine());
        stk = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());

        int[][] coordinate = new int[n][2];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            coordinate[i][0] = x;
            coordinate[i][1] = y;
        }

        Arrays.sort(coordinate, (c1, c2) -> {
           if (c1[0] == c2[0]) {
               return Integer.compare(c1[1], c2[1]);
           }
           return Integer.compare(c1[0], c2[0]);
        });

        int ans = 0;
        // 현재 좌표 (x, y)에 대해 (x+a, y), (x, y+b), (x+a, y+b)인 좌표가 모두 존재하는지 확인
        for (int i = 0; i < n - 1; i++) {
            int x = coordinate[i][0];
            int y = coordinate[i][1];
            if (isCoordinateExist(coordinate, i, x + a, y, n) &&
                isCoordinateExist(coordinate, i, x, y + b, n) &&
                isCoordinateExist(coordinate, i, x + a, y + b, n)) {
                ++ans;
            }
        }
        System.out.println(ans);
    }

    private static boolean isCoordinateExist(int[][] arr, int start, int targetX, int targetY, int n) {
        int low = start + 1;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int[] target = arr[mid];
            if (target[0] == targetX && target[1] == targetY) {
                return true;
            } else if (target[0] > targetX || (target[0] == targetX && target[1] > targetY)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}