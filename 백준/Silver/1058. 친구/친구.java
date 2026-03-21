import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        boolean[][] friendships = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            String line = bf.readLine();
            for (int c = 0; c < n; c++) {
                friendships[r][c] = line.charAt(c) == 'Y';
            }
        }

        int ans = 0;
        for (int a = 0; a < n; a++) {
            int count = 0;
            for (int b = 0; b < n; b++) {
                if (a == b) {
                    continue;
                }
                boolean isFriend = friendships[a][b] && friendships[b][a];
                for (int c = 0; c < n; c++) {
                    if (c == a || c == b) {
                        continue;
                    }

                    if (isFriend || (friendships[a][c] && friendships[b][c])) {
                        isFriend = true;
                        break;
                    }
                }
                count += isFriend ? 1 : 0;
            }
            ans = Integer.max(ans, count);
        }
        System.out.println(ans);
    }
}