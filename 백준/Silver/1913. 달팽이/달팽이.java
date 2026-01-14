import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];

        int[][] directions = new int[][] { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

        int[] pos = new int[2];
        for (int i = n / 2; i >= 0; i--) {
            int x = n / 2 - i;
            int y = n / 2 - i;
            int number = (i * 2 + 1) * (i * 2 + 1);
            if (number == target) {
                pos = new int[] {x, y};
            }
            matrix[x][y] = number;
            for (int [] direciton : directions) {
                while (true) {
                    int dx = x + direciton[0];
                    int dy = y + direciton[1];
                    if (dx < 0 || dy < 0 || dx >= n || dy >= n) {
                        break;
                    }
                    if (matrix[dx][dy] != 0) {
                        break;
                    }
                    --number;
                    matrix[dx][dy] = number;
                    x = dx;
                    y = dy;
                    if (number == target) {
                        pos = new int[] {x, y};
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int col : row) {
                sb.append(col).append(' ');
            }
            sb.append('\n');
        }
        sb.append(pos[0] + 1).append(' ').append(pos[1] + 1);
        System.out.println(sb);
    }
}