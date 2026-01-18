import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            // 오전 오후 구별 안하므로 1시간 당 30도
            // 1시간이 30도이므로 1분당 0.5도, 2분당 1도
            int degree = Integer.parseInt(br.readLine());
            int minute = degree * 2;
            sb.append('#').append(testCase).append(' ').append(minute / 60).append(' ').append(minute % 60).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}