import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (int j = 1; j <= word.length(); j++) {
                set.add(word.substring(0, j));
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            String word = br.readLine();
            if (set.contains(word)) {
                ++count;
            }
        }
        System.out.println(count);
    }
}