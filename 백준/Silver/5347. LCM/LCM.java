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
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long gcd = getGCD(a, b);
            long lcm = (a / gcd) * b;
            sb.append(lcm).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static long getGCD(long a, long b) {
        long min = Long.min(a, b);
        long max = Long.max(a, b);
        if (min == 0) {
            return max;
        }
        return getGCD(min, max % min);
    }
}

