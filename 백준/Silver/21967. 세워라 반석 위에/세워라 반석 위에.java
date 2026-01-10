import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        int left = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int right = 0; right < n; right++) {
            int rightValue = array[right];
            treeMap.put(rightValue, treeMap.getOrDefault(rightValue, 0) + 1);
            // 차이가 2 초과하면 2 이하로 줄어들 때까지 left 값 제거
            while (left < right && Math.abs(treeMap.firstKey() - treeMap.lastKey()) > 2) {
                int leftValue = array[left];
                if (treeMap.get(leftValue) == 1) {
                    treeMap.remove(leftValue);
                } else {
                    treeMap.put(leftValue, treeMap.get(leftValue) - 1);
                }
                ++left;
            }
            result = Integer.max(result, right - left + 1);
        }
        System.out.println(result);
    }
}