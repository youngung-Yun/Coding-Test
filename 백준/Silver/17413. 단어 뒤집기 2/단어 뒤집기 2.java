import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean isInAngleBracket = false;
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == '<') {
                isInAngleBracket = true;
                if (tmp.length() > 0) {
                    sb.append(tmp.reverse().toString());
                    tmp.setLength(0);
                }
                sb.append(ch);
                continue;
            } else if (ch == '>') {
                isInAngleBracket = false;
                sb.append(ch);
                continue;
            } else if (ch == ' ') {
                if (tmp.length() > 0) {
                    sb.append(tmp.reverse().toString());
                    tmp.setLength(0);
                }
                sb.append(ch);
                continue;
            }
            if (isInAngleBracket) {
                sb.append(ch);
                continue;
            }
            tmp.append(ch);
        }
        if (tmp.length() > 0) {
            sb.append(tmp.reverse().toString());
        }
        System.out.println(sb);
    }
}