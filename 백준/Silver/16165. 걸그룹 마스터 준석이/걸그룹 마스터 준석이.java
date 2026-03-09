import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        Map<String, List<String>> girlGroupMap = new HashMap<>();
        Map<String, String> memberMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String girlGroup = bf.readLine();
            girlGroupMap.put(girlGroup, new ArrayList<>());
            int memberCount = Integer.parseInt(bf.readLine());
            for (int member = 0; member < memberCount; member++) {
                String name = bf.readLine();
                girlGroupMap.get(girlGroup).add(name);
                memberMap.put(name, girlGroup);
            }
            girlGroupMap.get(girlGroup).sort((s1, s2) -> s1.compareTo(s2));
        }

        StringBuilder sb = new StringBuilder();
        for (int quiz = 0; quiz < m; quiz++) {
            String question = bf.readLine();
            int type = Integer.parseInt(bf.readLine());
            if (type == 0) {
                for (String member : girlGroupMap.get(question)) {
                    sb.append(member).append('\n');
                }
            } else {
                sb.append(memberMap.get(question)).append('\n');
            }
        }
        System.out.println(sb);
    }
}