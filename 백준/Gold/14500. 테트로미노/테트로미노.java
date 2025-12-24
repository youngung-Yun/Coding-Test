import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(row[j]);
            }
        }
        int[][][] tetrominoes = new int[][][] {
                /*
                 * 1. xxxx
                 * 2. x
                 *    x
                 *    x
                 *    x
                 */
                {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
                {{0, 0}, {1, 0}, {2, 0}, {3, 0}},

                /*
                 * 1. xx
                 *    xx
                 */
                {{0, 0}, {0, 1}, {1, 0}, {1, 1}},

                /*
                 * 1. x
                 *    x
                 *    xx
                 *
                 * 2. x
                 *    x
                 *   xx
                 *
                 * 3. xx
                 *    x
                 *    x
                 *
                 * 4. xx
                 *     x
                 *     x
                 *
                 * 5. x
                 *    xxx
                 *
                 * 6. xxx
                 *    x
                 *
                 * 7.  x
                 *   xxx
                 *
                 * 8. xxx
                 *      x
                 */
                {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
                {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
                {{0, 0}, {0, 1}, {1, 0}, {2, 0}},
                {{0, 0}, {0, -1}, {1, 0}, {2, 0}},
                {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
                {{0, 0}, {1, 0}, {0, 1}, {0, 2}},
                {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
                {{0, 0}, {0, 1}, {0, 2}, {1, 2}},

                /*
                 * 1. x
                 *    xx
                 *     x
                 *
                 * 2.  x
                 *    xx
                 *    x
                 *
                 * 3.  xx
                 *    xx
                 *
                 * 4. xx
                 *     xx
                 */
                {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
                {{0, 0}, {1, 0}, {1, -1}, {2, -1}},
                {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},
                {{0, 0}, {0, 1}, {1, 1}, {1, 2}},

                /*
                 * 1. xxx
                 *     x
                 *
                 * 2.  x
                 *    xxx
                 *
                 * 3.  x
                 *    xx
                 *     x
                 *
                 * 4. x
                 *    xx
                 *    x
                 */
                {{0, 0}, {0, 1}, {1, 1}, {0, 2}},
                {{0, 0}, {0, 1}, {-1, 1}, {0, 2}},
                {{0, 0}, {1, 0}, {1, -1}, {2, 0}},
                {{0, 0}, {1, 0}, {1, 1}, {2, 0}}};
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[][] tetromino : tetrominoes) {
                    int sum = 0;
                    for (int[] position : tetromino) {
                        int dx = i + position[0];
                        int dy = j + position[1];
                        if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                            sum = 0;
                            break;
                        }
                        sum += paper[dx][dy];
                    }
                    max = Integer.max(max, sum);
                }
            }
        }
        System.out.println(max);
    }
}