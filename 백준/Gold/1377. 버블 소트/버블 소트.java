import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        int[] sortedList = Arrays.stream(list).sorted().toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sortedList[i], i);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            int element = list[i];
            int sortedIdx = map.get(element);
            result = Math.max(result, i - sortedIdx + 1);
        }

        System.out.println(result);
    }
}