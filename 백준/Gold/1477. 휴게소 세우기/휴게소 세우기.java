import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());

        int[] restAreas = new int[n+1];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            restAreas[i] = Integer.parseInt(stk.nextToken());
        }
        restAreas[n] = l;

        Arrays.sort(restAreas);

        int low = 1;
        int high = l;

        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // 최대 간격 mid로 휴게소 건설 가능 = lower
            if (canBuildRestAreas(restAreas, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean canBuildRestAreas(int[] restAreas, int maxDistance, int limitCount) {
        int current = 0;

        int count = 0;
        for (int restArea : restAreas) {
            // 현재 휴게소 간격이 maxDistance보다 크면 휴게소 지어야 함
            while (restArea - current > maxDistance) {
                current += maxDistance;
                ++count;
            }
            current = restArea;
        }

        return count <= limitCount;
    }
}