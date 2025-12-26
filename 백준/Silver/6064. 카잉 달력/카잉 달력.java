import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long m = Integer.parseInt(st.nextToken());
            long n = Integer.parseInt(st.nextToken());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());

            long modX = m == x ? 0L : x;
            long modY = n == y ? 0L : y;
            long result = -1L;
            for (long i = modX; i <= m * n; i += m) {
                if (i == 0) {
                    continue;
                }
                if (i % n == modY) {
                    result = i;
                    break;
                }
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb.toString());
    }
}

