import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
    final static int OFFSET = 500;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {

            int[][] grid = new int[1_000][1_000];
            int[][] propagation = new int[1_000][1_000];

            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());

            // [x, y, currentTime]
            List<int[]> inactivates = new ArrayList<>();
            // [x, y, currentTime]
            List<int[]> activates = new ArrayList<>();

            for (int r = 0; r < n; r++) {
                stk = new StringTokenizer(bf.readLine());
                for (int c = 0; c < m; c++) {
                    int x = r + OFFSET;
                    int y = c + OFFSET;
                    int object = Integer.parseInt(stk.nextToken());
                    grid[x][y] = object;
                    if (object != 0) {
                        inactivates.add(new int[] {x, y, object});
                    }
                }
            }
            /*
             * 1. 비활성 리스트에서 하나씩 체크해 currentTime 1 감소
             * 2. 활성 리스트에서 하나씩 주위에 증식 후 currentTime 1 감소
             * 2-1. 우선 증식할 위치에 표시
             * 2-2. 해당 위치에 이미 증식한 미생물 있으면 생명력 비교
             * 3. 활성 리스트에서 currentTime이 0인 미생물은 사망
             * 4. 비활성 리스트에서 currentTime 이 0인 미생물을 활성 리스트로 옮김
             * 5. 증식한 미생물을 비활성 리스트에 추가
             */
            for (int i = 0; i < k; i++) {
                // 1.
                for (int[] micro : inactivates) {
                    int x = micro[0];
                    int y = micro[1];
                    --micro[2];
                }
                // 2.
                List<int[]> propagationList = new ArrayList<>();
                for (int[] micro : activates) {
                    int x = micro[0];
                    int y = micro[1];
                    --micro[2];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (grid[nx][ny] != 0) {
                            continue;
                        }
                        int life = grid[x][y];
                        // 그 위치로 처음 증식
                        if (propagation[nx][ny] == 0) {
                            propagationList.add(new int[] {nx, ny});
                            propagation[nx][ny] = life;
                        // 이미 다른 미생물이 증식한 상태
                        } else {
                            propagation[nx][ny] = Integer.max(propagation[nx][ny], life);
                        }
                    }
                }
                // 3.
                for (int idx = activates.size() - 1; idx >= 0; idx--) {
                    int[] micro = activates.get(idx);
                    if (micro[2] == 0) {
                        int x = micro[0];
                        int y = micro[1];
                        // 사망
                        grid[x][y] = -1;
                        activates.remove(idx);
                    }
                }
                // 4.
                for (int idx = inactivates.size() - 1; idx >= 0; idx--) {
                    int[] micro = inactivates.get(idx);
                    if (micro[2] == 0) {
                        int x = micro[0];
                        int y = micro[1];
                        int life = grid[x][y];
                        activates.add(new int[] {x, y, life});
                        inactivates.remove(idx);
                    }
                }
                // 5.
                for (int[] p : propagationList) {
                    int x = p[0];
                    int y = p[1];
                    int life = propagation[x][y];
                    grid[x][y] = life;
                    inactivates.add(new int[] {x, y, life});
                    propagation[x][y] = 0;
                }
            }
            int ans = inactivates.size() + activates.size();
            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
