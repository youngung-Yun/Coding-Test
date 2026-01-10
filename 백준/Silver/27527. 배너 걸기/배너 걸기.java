import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int needCount = (int) Math.ceil((9.0 * m) / 10.0);
        // [높이, 개수]
        Map<Integer, Integer> map = new HashMap<>();
        // init
        for (int i = 0; i < m; i++) {
            int height = heights[i];
            map.put(height, map.getOrDefault(height, 0) + 1);
            // 굳이 모든 요소의 개수를 셀 필요 없이, 현재 추가된 값의 개수만 확인하면 됨
            if (map.get(height) >= needCount) {
                System.out.println("YES");
                return;
            }
        }

        for (int i = m; i < n; i++) {
            int left = heights[i-m];
            map.put(left, map.get(left) - 1);
            int right = heights[i];
            map.put(right, map.getOrDefault(right, 0) + 1);
            if (map.get(right) >= needCount) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}