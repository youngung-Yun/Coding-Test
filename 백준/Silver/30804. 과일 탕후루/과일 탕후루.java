import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] fruits = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < n) {
            int fruit = fruits[right];
            // left를 이동
            if (!map.containsKey(fruit) && count == 2) {
                max = Integer.max(max, right - left);
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    --count;
                    map.remove(fruits[left]);
                }
                ++left;
                continue;
            }
            if (map.containsKey(fruit)) {
                map.put(fruit, map.get(fruit) + 1);
            } else {
                ++count;
                map.put(fruit, 1);
            }
            ++right;
        }
        max = Integer.max(max, n - left);
        System.out.println(max);
    }
}
