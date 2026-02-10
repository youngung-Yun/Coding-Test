import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static int ans;
    static boolean[] colVisited;
    static boolean[] slashVisited;
    static boolean[] backslashVisited;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            ans = 0;
            n = Integer.parseInt(bf.readLine());

            colVisited = new boolean[n];
            // r + c
            slashVisited = new boolean[2*n-1];
            // c - r + n - 1
            backslashVisited = new boolean[2*n-1];

            dfs(0);

            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');

        }
        System.out.println(sb);
    }

    static void dfs(int row) {
        if (row == n) {
            ++ans;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (colVisited[col] || slashVisited[row+col] || backslashVisited[col-row+n-1]) {
                continue;
            }
            colVisited[col] = true;
            slashVisited[row+col] = true;
            backslashVisited[col-row+n-1] = true;
            dfs(row + 1);
            backslashVisited[col-row+n-1] = false;
            slashVisited[row+col] = false;
            colVisited[col] = false;
        }
    }
}
