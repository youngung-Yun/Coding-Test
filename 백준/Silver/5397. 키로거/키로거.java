import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int max = -801;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int cursor = 0;
            List<Character> password = new LinkedList<>();
            String keyLog = br.readLine();
            for (char ch : keyLog.toCharArray()) {
                if (ch == '<') {
                    cursor = Math.max(cursor - 1, 0);
                } else if (ch == '>') {
                    cursor = Math.min(cursor + 1, password.size());
                } else if (ch == '-') {
                    if (cursor > 0) {
                        --cursor;
                        password.remove(cursor);
                    }
                } else {
                    password.add(cursor, ch);
                    ++cursor;
                }
            }
            for (char ch : password) {
                sb.append(ch);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}