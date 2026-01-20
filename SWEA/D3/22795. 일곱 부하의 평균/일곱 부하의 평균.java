import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int maxHeight = 0;
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                int height = Integer.parseInt(st.nextToken());
                sum += height;
                maxHeight = Integer.max(maxHeight, height);
            }
            int answer = maxHeight + 1;
            while ((sum + answer) %  7 != 0) {
                ++answer;
            }
            System.out.println(answer);
        }
        System.out.println(sb);
    }
}