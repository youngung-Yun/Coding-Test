import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int limit = Integer.parseInt(stk.nextToken());

        int m = Integer.parseInt(bf.readLine());
        int[][] parcels = new int[m][3];

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int amount = Integer.parseInt(stk.nextToken());

            parcels[i] = new int[] {from, to, amount};
        }

        // 출발지와 도착지가 가까운 순 정렬, 같으면 가까운 마을부터
        Arrays.sort(parcels, (a1, a2) -> {
            int compared = Integer.compare(a1[1], a2[1]);
            if (compared == 0) {
                return Integer.compare(a1[0], a2[0]);
            }
            return compared;
        });

        int[] capacity = new int[n+1];
        int ans = 0;
        for (int[] parcel : parcels) {
            int from = parcel[0];
            int to = parcel[1];
            int amount = parcel[2];

            int maxLoaded = amount;
            for (int i = from; i < to; i++) {
                maxLoaded = Integer.min(maxLoaded, limit - capacity[i]);
            }
            for (int i = from; i < to; i++) {
                capacity[i] += maxLoaded;
            }
            ans += maxLoaded;
        }

        System.out.println(ans);
    }
}
