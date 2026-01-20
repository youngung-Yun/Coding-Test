import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long d = Long.parseLong(st.nextToken());
            long l = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());

            long totalDamage = 0L;
            for (int count = 0; count < n; ++count) {
                totalDamage += computeDamage(d, l, count);
            }
            sb.append('#').append(testCase).append(' ').append(totalDamage).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    // D + ((D/100) * n * L)
    static long computeDamage(long defaultDamage, long level, long hitCount) {
        return defaultDamage + (defaultDamage / 100L) * hitCount * level;
    }
}