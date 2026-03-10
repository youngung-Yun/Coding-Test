import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long number = Long.parseLong(bf.readLine());
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int maxCount = 0;
        long ans = Long.MAX_VALUE;
        for (long number : map.keySet()) {
            if (maxCount < map.get(number) || (maxCount == map.get(number) && ans > number)) {
                maxCount = map.get(number);
                ans = number;
            }
        }
        System.out.println(ans);
    }

}