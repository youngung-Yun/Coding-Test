import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                matrix[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(recursion(0, 0, n));
    }

    static int recursion(int x, int y, int n) {
        if (n == 1) {
            return matrix[x][y];
        }

        int[] array = new int[4];
        int half = n / 2;
        array[0] = recursion(x, y, half);
        array[1] = recursion(x, y + half, half);
        array[2] = recursion(x + half, y, half);
        array[3] = recursion(x + half, y + half, half);
        Arrays.sort(array);

        return array[1];

    }
}