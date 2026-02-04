import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int win;
    static int lose;

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(buffer.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            win = 0;
            lose = 0;
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            boolean[] visited = new boolean[19];
            int[] myCard = new int[9];
            for (int i = 0; i < 9; i++) {
                int card = Integer.parseInt(token.nextToken());
                myCard[i] = card;
                visited[card] = true;
            }

            dfs(myCard, new int[9], visited, 0, 9);

            sb.append('#').append(testCase).append(' ')
                    .append(win).append(' ').append(lose).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int[] my, int[] opponent, boolean[] visited,
                    int depth, int n) {
        if (depth == n) {
            int myPoint = 0;
            int opponentPoint = 0;
            for (int i = 0; i < n; i++) {
                int sum = my[i] + opponent[i];
                if (my[i] > opponent[i]) {
                    myPoint += sum;
                } else {
                    opponentPoint += sum;
                }
            }
            if (myPoint > opponentPoint) {
                ++win;
            } else if (myPoint < opponentPoint) {
                ++lose;
            }
            return;
        }

        for (int i = 1; i <= 18; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            opponent[depth] = i;
            dfs(my, opponent, visited, depth + 1, n);
            visited[i] = false;
        }
    }
}
