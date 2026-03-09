import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        Map<Integer, Integer> countingMap = new HashMap<>();
        Map<Integer, Integer> orderMap = new HashMap<>();

        Integer[] array = new Integer[n];
        int order = 1;
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            Integer number = Integer.valueOf(stk.nextToken());
            array[i] = number;

            countingMap.put(number, countingMap.getOrDefault(number, 0) + 1);
            if (!orderMap.containsKey(number)) {
                orderMap.put(number, order++);
            }
        }

        Arrays.sort(array, (n1, n2) -> {
            if (countingMap.get(n1) != countingMap.get(n2)) {
                return Integer.compare(countingMap.get(n2), countingMap.get(n1));
            }
            return Integer.compare(orderMap.get(n1), orderMap.get(n2));
        });

        StringBuilder sb = new StringBuilder();
        for (int number : array) {
            sb.append(number).append(' ');
        }
        System.out.println(sb);
    }
}