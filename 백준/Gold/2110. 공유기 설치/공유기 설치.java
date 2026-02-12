import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int MAX = 1_000_000_000;

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(house);

        // 최대 거리로 공유기 c개 설치 가능한지 확인하는 파라메트릭 서치
        // upper bound
        int low = 0;
        int high = MAX;
        int ans = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // 해당 최대 거리로 공유기 c개 이상 설치 가능
            if (canSetupRouter(house, c, mid, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean canSetupRouter(int[] house, int routerCount, int distance, int n) {
        int currentCount = 0;
        int leftRouter = 0;
        for (int router = 0; router < n; router++) {
            // 맨 처음 집이거나,
            // 왼쪽에 있는 라우터가 설치된 집과 최대 거리 이상 멀어질 때마다 라우터 설치
            if (router == 0 || house[router] - leftRouter >= distance) {
                ++currentCount;
                leftRouter = house[router];
            }
        }
        // c개 이상 설치 가능한지
        return currentCount >= routerCount;
    }
}