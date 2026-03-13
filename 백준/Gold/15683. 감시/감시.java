import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    final static int[][] offsets = { {}, {0}, {0, 2}, {0, 1}, {0, 1, 2}, {0, 1, 2, 3} };

    static int ans;
    static int n;
    static int m;
    static int totalArea = 0;
    static List<int[]> cctvList = new ArrayList<>();
    static int[][] office;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        office = new int[n][m];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < m; c++) {
                int object = Integer.parseInt(stk.nextToken());
                office[r][c] = object;
                if (object > 0 && object < 6) {
                    cctvList.add(new int[] {r, c});
                } else if (object == 0) {
                    ++totalArea;
                }
            }
        }

        ans = totalArea;

        int cctvCount = cctvList.size();
        dfs(new int[cctvCount], 0, cctvCount);

        System.out.println(ans);
    }

    private static int security(int[] dirArray) {
        int area = totalArea;
        boolean[][] checked = new boolean[n][m];
        for (int i = 0; i < cctvList.size(); i++) {
            int[] cctv = cctvList.get(i);
            int r = cctv[0];
            int c = cctv[1];
            int type = office[r][c];
            int d = dirArray[i];
            for (int offset : offsets[type]) {
                int dr = dirs[(d+offset)%4][0];
                int dc = dirs[(d+offset)%4][1];

                int nr = r + dr;
                int nc = c + dc;

                while (isValid(nr, nc) && office[nr][nc] != 6) {
                    if (!checked[nr][nc] && office[nr][nc] == 0) {
                        checked[nr][nc] = true;
                        --area;
                    }
                    nr += dr;
                    nc += dc;
                }
            }
        }
        return area;
    }

    private static boolean isValid(int r, int c) {
         return r >= 0 && c >= 0 && r < n && c < m;
    }

    private static void dfs(int[] dirArray, int depth, int n) {
        if (depth == n) {
            int area = security(dirArray);
            ans = Integer.min(ans, area);
            return;
        }

        for (int d = 0; d < 4; d++) {
            dirArray[depth] = d;
            dfs(dirArray, depth + 1, n);
        }
    }
}