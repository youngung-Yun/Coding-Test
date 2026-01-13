import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, String> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            if (!map.containsKey(power)) {
                map.put(power, title);
                list.add(power);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int userPower = Integer.parseInt(br.readLine());
            // 조건: 칭호 컷이 전투력보다 크거나 같음
            // 방식: lower bound
            int low = 0;
            int high = list.size();
            while (low < high) {
                int mid = (low + high) / 2;
                if (list.get(mid) >= userPower) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            sb.append(map.get(list.get(low))).append('\n');
        }
        System.out.println(sb);
    }
}