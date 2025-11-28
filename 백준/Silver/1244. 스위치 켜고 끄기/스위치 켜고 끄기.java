import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] switches = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            switches[i] = st.nextToken().equals("1") ? true : false;
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            // 1=남, 2=여
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                for (int k = number; k <= n; k += number) {
                    switches[k] = !switches[k];
                }
            } else {
                int length = 0;
                while (number - length > 0 && number + length <= n) {
                    if (switches[number - length] == switches[number + length]) {
                        ++length;
                    } else {
                        break;
                    }
                }
                --length;
                for (int k = number - length; k <= number + length; k++) {
                    switches[k] = !switches[k];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            boolean isOn = switches[i];
            sb.append(isOn ? '1' : '0').append(' ');
            if (i % 20 == 0) {
                sb.append('\n');
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}