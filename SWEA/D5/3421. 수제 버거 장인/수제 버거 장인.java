import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());
            int[] matches = new int[m];
            for (int i = 0; i < m; i++) {
                token = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                matches[i] = ((0b1 << (a - 1)) | (0b1 << (b - 1)));
            }
            int ans = 0;
            for (int i = 0; i < 0b1 << n; i++) {
                boolean canMake = true;
                for (int match : matches) {
                    if ((i & match) == match) {
                        canMake = false;
                        break;
                    }
                }
                ans += canMake ? 1 : 0;
            }
            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
