import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    final static int OFFSET = 1_000;

    // 좌표 기준 상, 하, 좌, 우
    final static int[][] dirs ={ {0, 1}, {0, -1}, {-1, 0}, {1, 0} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = Integer.parseInt(bf.readLine());

            // [x, y, dir]
            int[][] atoms = new int[n][3];
            int[] energies = new int[n];
            boolean[] isDead = new boolean[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer token = new StringTokenizer(bf.readLine());
                int x = (Integer.parseInt(token.nextToken()) + OFFSET) * 2;
                int y = (Integer.parseInt(token.nextToken()) + OFFSET) * 2;
                int dir = Integer.parseInt(token.nextToken());
                int energy = Integer.parseInt(token.nextToken());
                atoms[i] = new int[] { x, y, dir };
                energies[i] = energy;
            }

            int atomCount = n;
            int totalEnergy = 0;
            // 0.5초 단위로 이동하기 위해 좌표 범위를 2배로 늘림
            int[][] grid = new int[4001][4001];
            for (int[] row : grid) {
                Arrays.fill(row, -1);
            }
            for (int d = 0; d <= 4_000; d++) {
                for (int i = 0; i < n; i++) {
                    if (atomCount == 0) {
                        break;
                    }
                    if (isDead[i]) {
                        continue;
                    }
                    // 원자 이동
                    int[] atom = atoms[i];
                    int nx = atom[0] + dirs[atom[2]][0];
                    int ny = atom[1] + dirs[atom[2]][1];

                    // 범위 밖으로 나간 원자는 절대 충돌안함
                    if (!isValid(nx, ny)) {
                        --atomCount;
                        isDead[i] = true;
                        continue;
                    }

                    atom[0] = nx;
                    atom[1] = ny;

                    if (grid[nx][ny] == -1) {
                        grid[nx][ny] = i;
                    } else {
                        // 이동 위치에 이미 다른 원자가 있을 경우
                        int other = grid[nx][ny];
                        if (isDead[other]) {
                            // 부딪힌 원자 사망 처리
                            totalEnergy += energies[i];
                            isDead[i] = true;
                            --atomCount;
                        } else {
                            // 부딪힌 원자 및 이미 존재하던 원자 사망 처리
                            totalEnergy += energies[other];
                            totalEnergy += energies[i];
                            isDead[other] = true;
                            isDead[i] = true;
                            atomCount -= 2;
                        }
                    }
                }

                if (atomCount == 0) {
                    break;
                }

                for (int i = 0; i < n; i++) {
                    int[] atom = atoms[i];
                    grid[atom[0]][atom[1]] = -1;
                }
            }
            sb.append('#').append(testCase).append(' ')
                    .append(totalEnergy).append('\n');
        }
        System.out.println(sb);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x <= 4_000 && y <= 4_000;
    }

}