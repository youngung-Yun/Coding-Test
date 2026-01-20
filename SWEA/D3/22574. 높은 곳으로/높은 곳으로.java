import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long p = Long.parseLong(st.nextToken());

            long i = 1L;
            long sum = 0L;
            while (i <= n && sum < p) {
                sum += i;
                ++i;
            }

            boolean isDangerous;
            if (sum == p) {
                isDangerous = true;
            } else {
                isDangerous = false;
            }

            long floor = (n * (n + 1)) / 2L;
            System.out.println(isDangerous ? floor - 1L : floor);
        }
    }
}