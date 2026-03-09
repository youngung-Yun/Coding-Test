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
        int k = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());

        int order = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            String id = bf.readLine();
            map.put(id, order++);
        }

        String[] ids = map.keySet().toArray(new String[0]);
        Arrays.sort(ids, (s1, s2) -> Integer.compare(map.get(s1), map.get(s2)));

        for (int i = 0; i < Integer.min(k, ids.length); i++) {
            System.out.println(ids[i]);
        }
    }
}