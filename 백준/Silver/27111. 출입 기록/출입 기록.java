import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> entranceArchive = new HashSet<>();

        int n = Integer.parseInt(bf.readLine());

        int ans = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int people = Integer.parseInt(stk.nextToken());
            int inout = Integer.parseInt(stk.nextToken());

            // 들어감
            if (inout == 1) {
                if (entranceArchive.contains(people)) {
                    ++ans;
                } else {
                    entranceArchive.add(people);
                }
            // 나감
            } else {
                if (!entranceArchive.contains(people)) {
                    ++ans;
                } else {
                    entranceArchive.remove(people);
                }
            }
        }
        ans += entranceArchive.size();
        System.out.println(ans);
    }
}