import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<String, String> parentMap;
    static Map<String, Integer> sizeMap;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            parentMap = new HashMap<>();
            sizeMap = new HashMap<>();

            int f = Integer.parseInt(bf.readLine());
            for (int i = 0; i < f; i++) {
                StringTokenizer stk = new StringTokenizer(bf.readLine());
                String a = stk.nextToken();
                String b = stk.nextToken();

                union(a, b);
                if (a.compareTo(b) > 0) {
                    sb.append(sizeMap.get(find(a))).append('\n');
                } else {
                    sb.append(sizeMap.get(find(b))).append('\n');
                }
            }
        }
        System.out.println(sb);
    }

    private static String find(String x) {
        if (!parentMap.containsKey(x)) {
            parentMap.put(x, x);
            if (!sizeMap.containsKey(x)) {
                sizeMap.put(x, 1);
            }
        } else if (!x.equals(parentMap.get(x))) {
            parentMap.put(x, find(parentMap.get(x)));
        }
        return parentMap.get(x);
    }

    private static boolean union(String x, String y) {
        String parentX = find(x);
        String parentY = find(y);

        if (parentX.equals(parentY)) {
            return false;
        }

        if (parentX.compareTo(parentY) > 0) {
            sizeMap.put(parentX, sizeMap.get(parentX) + sizeMap.get(parentMap.get(parentY)));
            parentMap.put(parentMap.get(parentY), parentX);
        } else {
            sizeMap.put(parentY, sizeMap.get(parentY) + sizeMap.get(parentMap.get(parentX)));
            parentMap.put(parentMap.get(parentX), parentY);
        }

        return true;
    }
}
