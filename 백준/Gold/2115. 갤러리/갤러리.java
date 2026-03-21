import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 왼쪽, 오른쪽, 위, 아래
    final static int[][] walls = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
    final static int[][] aside = { {1, 0}, {1, 0}, {0, 1}, {0, 1} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        char[][] gallery = new char[n][m];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++) {
                gallery[r][c] = row.charAt(c);
            }
        }

        int ans = 0;
        // 나의 왼/오른/위/아래에 그림이 걸려있는지
        boolean[][] [] hung = new boolean[n][m] [4];

        for (int r = 1; r < n - 1; r++) {
            for (int c = 1; c < m - 1; c++) {
                if (gallery[r][c] == 'X') {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int asideR = r + aside[i][0];
                    int asideC = c + aside[i][1];
                    // 그림을 걸 옆 공간이 벽이거나 이미 해당 방향에 그림이 걸려있음
                    if (gallery[asideR][asideC] == 'X' || hung[r][c][i] || hung[asideR][asideC][i]) {
                        continue;
                    }

                    int currWallR = r + walls[i][0];
                    int currWallC = c + walls[i][1];
                    int asideWallR = asideR + walls[i][0];
                    int asideWallC = asideC + walls[i][1];

                    // 그림을 걸 방향의 공간이 벽이 아님
                    if (gallery[currWallR][currWallC] != 'X' || gallery[asideWallR][asideWallC] != 'X') {
                        continue;
                    }

                    hung[r][c][i] = hung[asideR][asideC][i] = true;
                    ++ans;
                }
            }
        }
        System.out.println(ans);
    }
}