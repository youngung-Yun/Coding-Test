import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[] hay = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int e = Integer.parseInt(br.readLine());
                hay[i] = e;
                sum += e;
            }
            sum /= n;
            int count = 0;
            for (int h : hay) {
                if (sum > h) {
                    count += (sum - h);
                }
            }
            sb.append('#').append(testCase).append(' ').append(count).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}