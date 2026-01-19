import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] pos = new int[301][301];
        int[][] number = new int[100_000][2];

        int n = 1;
        for (int x = 1; x <= 300; x++) {
            for (int d = 0; d < x; d++) {
                pos[x-d][1+d] = n;
                number[n] = new int[] {x-d, 1+d};
                ++n;
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[] p = number[x];
            int[] q = number[y];
            int[] sum = {p[0] + q[0], p[1] + q[1]};

            int answer = pos[sum[0]][sum[1]];
            sb.append('#').append(testCase).append(' ').append(answer).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}