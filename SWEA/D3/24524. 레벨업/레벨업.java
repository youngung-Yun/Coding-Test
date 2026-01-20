import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[] checkpoints = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int min = 50 * 200 + 1;
            for (int exclude = 1; exclude < n - 1; ++exclude) {
                int sum = 0;
                int prev = 0;
                for (int curr = 1; curr < n; ++curr) {
                    if (exclude == curr) {
                        continue;
                    }
                    sum += Math.abs(checkpoints[curr] - checkpoints[prev]);
                    prev = curr;
                }
                min = Integer.min(min, sum);
            }
            System.out.println(min);
        }
    }
}