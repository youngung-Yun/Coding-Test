import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new TreeSet<>((s1, s2) -> -s1.compareTo(s2));

        for (int i = 0; i < n; i++) {
            String[] log = br.readLine().split(" ");
            if (log[1].equals("enter")) {
                set.add(log[0]);
            } else {
                set.remove(log[0]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String name : set) {
            sb.append(name).append('\n');
        }

        System.out.println(sb.toString());
    }
}