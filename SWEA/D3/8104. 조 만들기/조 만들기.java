import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] grades = new int[k][n];
            int number = 1;
            for (int col = 0; col < n; ++col) {
                for (int row = 0; row < k; ++row) {
                    if (col % 2 == 0) {
                        grades[row][col] = number++;
                    } else {
                        grades[k - 1 - row][col] = number++;
                    }
                }
            }

            sb.append('#').append(testCase).append(' ');
            for (int[] team : grades) {
                sb.append(Arrays.stream(team).sum()).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}