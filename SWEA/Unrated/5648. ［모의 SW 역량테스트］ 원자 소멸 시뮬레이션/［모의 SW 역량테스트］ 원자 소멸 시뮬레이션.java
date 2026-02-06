import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Watchable;
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
                atoms[i] = new int[] { x, y, dir, energy };
                energies[i] = energy;
            }

            int atomCount = n;
            int totalEnergy = 0;
            int[][] grid = new int[4001][4001];
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

                    if (!isValid(nx, ny)) {
                        --atomCount;
                        isDead[i] = true;
                        continue;
                    }

                    atom[0] = nx;
                    atom[1] = ny;

                    if (grid[nx][ny] == 0) {
                        grid[nx][ny] = i + 1;
                    } else {
                        int other = grid[nx][ny] - 1;
                        if (isDead[other]) {
                            totalEnergy += energies[i];
                            isDead[i] = true;
                            --atomCount;
                        } else {
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
                    grid[atom[0]][atom[1]] = 0;
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