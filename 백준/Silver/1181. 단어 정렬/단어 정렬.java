import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new TreeSet<>((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            } else {
                return s1.compareTo(s2);
            }
        });

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            set.add(word);
        }

        StringBuilder sb = new StringBuilder();
        for (String word : set) {
            sb.append(word).append('\n');
        }
        System.out.println(sb.toString());
    }
}