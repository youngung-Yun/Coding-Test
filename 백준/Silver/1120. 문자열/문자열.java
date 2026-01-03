import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int result = a.length();
        for (int i = 0; i <= b.length() - a.length(); i++) {
            int diff = 0;
            for (int k = 0; k < a.length(); k++) {
                if (a.charAt(k) != b.charAt(k+i)) {
                    ++diff;
                }
            }
            result = Integer.min(result, diff);
        }
        System.out.println(result);
    }

}
