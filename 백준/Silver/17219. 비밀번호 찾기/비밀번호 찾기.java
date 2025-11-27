import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        // {사이트: 비밀번호}
        Map<String, String> passwordMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            passwordMap.put(input[0], input[1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String domain = br.readLine();
            sb.append(passwordMap.get(domain)).append('\n');
        }

        System.out.println(sb.toString());
    }
}