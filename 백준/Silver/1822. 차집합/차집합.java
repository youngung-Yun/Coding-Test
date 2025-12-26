import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Long> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        String[] array = br.readLine().split(" ");
        for (String e : array) {
            set.add(Long.parseLong(e));
        }
        array = br.readLine().split(" ");
        for (String e : array) {
            long number = Long.parseLong(e);
            set.remove(number);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(set.size()).append('\n');
        for (Long e : set) {
            sb.append(e).append(' ');
        }
        System.out.println(sb.toString());
    }
}

