import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int[][] dirs = {{}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());

            int[] x = new int[k];
            int[] y = new int[k];
            int[] amount = new int[k];
            int[] d = new int[k];

            for (int i = 0; i < k; i++) {
                stk = new StringTokenizer(bf.readLine());
                x[i] = Integer.parseInt(stk.nextToken());
                y[i] = Integer.parseInt(stk.nextToken());
                amount[i] = Integer.parseInt(stk.nextToken());
                d[i] = Integer.parseInt(stk.nextToken());
            }

            // [idx, totalAmount]
            int[][][] mergeGrid = new int[n][n][2];
            /*
             * 1. 각 미생물을 이동
             * 1-1. 도착했는데 가장자리면 수 / 2, 방향 전환. 사망했으면 continue
             * 1-2. 해당 위치에 도착한 미생물 있으면 수가 더 적은 미생물 사망
             * 1-3. 내가 처음 도착했으면 이동 위치 리스트에 저장
             * 2. 미생물 수 갱신 및 격자 초기화
             */
            for (int time = 0; time < m; time++) {
                // [x, y]
                List<int[]> arriveList = new ArrayList<>();
                // 1.
                for (int i = 0; i < k; i++) {
                    // 수가 0인 미생물 (사망)
                    if (amount[i] == 0) {
                        continue;
                    }

                    int nx = x[i] + dirs[d[i]][0];
                    int ny = y[i] + dirs[d[i]][1];
                    // 1-1.
                    if (isInEdge(nx, ny, n)) {
                        d[i] = changeDirection(d[i]);
                        amount[i] /= 2;
                        // 약품에 닿아 모두 죽음
                        if (amount[i] == 0) {
                            continue;
                        }
                    }
                    // 이미 다른 미생물이 있음
                    if (mergeGrid[nx][ny][1] != 0) {
                        mergeGrid[nx][ny][1] += amount[i];
                        int other = mergeGrid[nx][ny][0];
                        // 수가 적은 쪽이 사망
                        if (amount[i] > amount[other]) {
                            amount[other] = 0;
                            mergeGrid[nx][ny][0] = i;
                        } else {
                            amount[i] = 0;
                        }
                    } else {
                        // 내가 처음 도착
                        mergeGrid[nx][ny][0] = i;
                        mergeGrid[nx][ny][1] = amount[i];
                        arriveList.add(new int[] {nx, ny});
                    }
                    x[i] = nx;
                    y[i] = ny;
                }
                // 미생물 수 갱신 및 격자 초기화
                for (int[] arrive : arriveList) {
                    int nx = arrive[0];
                    int ny = arrive[1];
                    int idx = mergeGrid[nx][ny][0];
                    amount[idx] = mergeGrid[nx][ny][1];
                    mergeGrid[nx][ny][0] = 0;
                    mergeGrid[nx][ny][1] = 0;
                }
            }

            int ans = 0;
            for (int a : amount) {
                ans += a;
            }
            sb.append('#').append(testCase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static int changeDirection(int dir) {
        return dir % 2 == 1 ? dir + 1 : dir - 1;
    }

    static boolean isInEdge(int x, int y, int n) {
        return x == 0 || y == 0 || x == n - 1 || y == n - 1;
    }
}
