import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            String[] sounds = br.readLine().split(" ");
            Map<String, String> sound = new HashMap<>();
            while (true) {
                String message = br.readLine();
                if (message.equals("what does the fox say?")) {
                    break;
                }
                String[] split = message.split(" ");
                sound.put(split[2], split[0]);
            }
            for (String s : sounds) {
                if (!sound.containsKey(s)) {
                    sb.append(s).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
