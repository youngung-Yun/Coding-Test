import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String map = bf.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(map.charAt(0));
        for (int i = 1; i < n; i++) {
            char curr = map.charAt(i);
            char last = sb.charAt(sb.length() - 1);
            if (curr != last) {
                sb.append(curr);
            }
        }

        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            ++count;
            if (i < sb.length() - 1 && sb.charAt(i) == 'E' && sb.charAt(i+1) == 'W') {
                ++i;
            }
        }
        System.out.println(count);
    }
}