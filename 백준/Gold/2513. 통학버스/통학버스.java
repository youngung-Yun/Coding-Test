import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int limit = Integer.parseInt(stk.nextToken());
        int school = Integer.parseInt(stk.nextToken());

        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            int coord = Integer.parseInt(stk.nextToken());
            int people = Integer.parseInt(stk.nextToken());

            int distance = Math.abs(school - coord);
            int[] apart = new int[] {distance, people};
            if (coord < school) {
                left.add(apart);
            } else {
                right.add(apart);
            }
        }

        // 먼 순으로 정렬
        left.sort((a1, a2) -> Integer.compare(a2[0], a1[0]));
        right.sort((a1, a2) -> Integer.compare(a2[0], a1[0]));

        int ans = getMinDistance(left, left.size(), limit) + getMinDistance(right, right.size(), limit);
        System.out.println(ans);
    }

    static int getMinDistance(List<int[]> coords, int n, int limit) {
        int idx = 0;
        int total = 0;
        while (idx < n) {
            int curr = 0;
            total += coords.get(idx)[0] * 2;
            while (idx < coords.size() && curr + coords.get(idx)[1] <= limit) {
                curr += coords.get(idx)[1];
                ++idx;
            }
            if (idx < n) {
                coords.get(idx)[1] -= (limit - curr);
            }
        }
        return total;
    }
}