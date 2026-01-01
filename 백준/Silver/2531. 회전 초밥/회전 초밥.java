import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushies = new int[n];
        for (int i = 0; i < n; i++) {
            sushies[i] = Integer.parseInt(br.readLine());
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int sushi = sushies[i];
            map.put(sushi, map.getOrDefault(sushi, 0) + 1);
        }

        int result = 0;
        int left = 0;
        int right = k - 1;
        for (int i = 0; i < n; i++) {
            int variety = map.keySet().size();
            if (!map.containsKey(c)) {
                ++variety;
            }
            result = Integer.max(result, variety);

            // 가장 왼쪽 초밥 제거
            int removedSushi = sushies[left];
            if (map.get(removedSushi) == 1) {
                map.remove(removedSushi);
            } else {
                map.put(removedSushi, map.get(removedSushi) - 1);
            }
            left = (left + 1) % n;

            // 오른쪽에 초밥 추가
            right = (right + 1) % n;
            int addedSushi = sushies[right];
            map.put(addedSushi, map.getOrDefault(addedSushi, 0) + 1);
        }
        System.out.println(result);
    }
}