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
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String[] arr1 = br.readLine().split(" ");
            String[] arr2 = br.readLine().split(" ");
            int q = Integer.parseInt(br.readLine());
            sb.append('#').append(testCase).append(' ');
            for (int i = 0; i < q; i++) {
                int year = Integer.parseInt(br.readLine());
                sb.append(arr1[(year-1) % n]).append(arr2[(year-1) % m]).append(' ');
            }
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }
}