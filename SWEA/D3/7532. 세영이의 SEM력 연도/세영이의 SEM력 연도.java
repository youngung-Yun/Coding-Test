import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int year = 1;
            while (true) {
                if (getMod(year, 365) == s && getMod(year, 24) == e && getMod(year, 29) == m) {
                    break;
                }
                ++year;
            }
            sb.append('#').append(testCase).append(' ').append(year).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    static int getMod(int n, int mod) {
        int result = n % mod;
        if (result == 0) {
            return mod;
        } else {
            return result;
        }
    }
}