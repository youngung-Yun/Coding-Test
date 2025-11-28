import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int radius = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n - 1; i++) {
            int r = Integer.parseInt(st.nextToken());
            int gcd = getGCD(radius, r);
            sb.append(radius / gcd).append('/').append(r / gcd).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static int getGCD(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (min == 0) {
            return max;
        }
        return getGCD(b, a % b);
    }
}