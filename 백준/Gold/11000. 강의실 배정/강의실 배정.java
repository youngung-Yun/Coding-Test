import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        List<int[]> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            events.add(new int[] {start, +1});
            events.add(new int[] {end, -1});
        }

        events.sort((a1, a2) -> {
            if (a1[0] == a2[0]) {
                // 끝난 강의 먼저 처리
                return Integer.compare(a1[1], a2[1]);
            }
            return Integer.compare(a1[0], a2[0]);
        });

        int ans = 0;
        int count = 0;
        for (int[] event : events) {
            count += event[1];
            ans = Integer.max(ans, count);
        }

        System.out.println(ans);
    }
}
