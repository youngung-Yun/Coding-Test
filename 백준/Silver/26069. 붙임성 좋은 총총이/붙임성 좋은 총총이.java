import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> rainbowDance = new HashSet<>();
        rainbowDance.add("ChongChong");
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String human1 = st.nextToken();
            String human2 = st.nextToken();
            if (rainbowDance.contains(human1)) {
                rainbowDance.add(human2);
            } else if (rainbowDance.contains(human2)) {
                rainbowDance.add(human1);
            }
        }
        System.out.println(rainbowDance.size());
    }
}