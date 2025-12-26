import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = 0;
        while (true) {
            ++testCase;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (p == 0) {
                break;
            }
            int result = (v / p) * l;
            result += Integer.min((v % p), l);
            sb.append("Case ").append(testCase).append(": ").append(result).append('\n');
        }
        System.out.println(sb.toString());
    }
}

