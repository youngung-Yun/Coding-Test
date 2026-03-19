import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Map<String, Integer> enterMap = new HashMap<>();
        String[] enter = new String[n];
        for (int i = 0; i < n; i++) {
            enter[i] = bf.readLine();
            enterMap.put(enter[i], i);
        }

        Map<String, Integer> exitMap = new HashMap<>();
        String[] exit = new String[n];
        for (int i = 0; i < n; i++) {
            exit[i] = bf.readLine();
            exitMap.put(exit[i], i);
        }

        // 추월한 차량이다 == 터널 진입 전 내 앞에 있던 차량 중 하나라도
        // 진입 후 내 뒤에 있으면 추월을 했음.
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int currentOrder = exitMap.get(enter[i]);
            for (int prev = 0; prev < i; prev++) {
                String prevCar = enter[prev];
                if (exitMap.get(prevCar) > currentOrder) {
                    ++ans;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}