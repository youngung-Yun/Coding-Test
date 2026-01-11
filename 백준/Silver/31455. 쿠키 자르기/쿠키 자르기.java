import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String row = br.readLine();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Character.getNumericValue(row.charAt(j));
                }
            }
            int result = recursion(matrix, 0, 0, n);
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    static int recursion(int[][] matrix, int x, int y, int n) {
        if (n == 1) {
            return matrix[x][y];
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                total += matrix[x+i][y+j];
            }
        }
        int half = n / 2;
        int[][] quadrant = new int[][] {{x, y}, {x, y + half}, {x + half, y}, {x + half, y + half}};
        int mod = total % 4;

        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (i == mod) {
                continue;
            }
            result += recursion(matrix, quadrant[i][0], quadrant[i][1], half);
        }
        return result;
    }

}