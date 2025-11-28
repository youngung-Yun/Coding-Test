import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] a = makeMatrix(br);
        int[][] b = makeMatrix(br);

        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < b.length; k++) {
                    sum += (a[i][k] * b[k][j]);
                }
                result[i][j] = sum;

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    private static int[][] makeMatrix(BufferedReader br) throws Exception {
        String[] tmp = br.readLine().split(" ");
        int row = Integer.parseInt(tmp[0]);
        int col = Integer.parseInt(tmp[1]);

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }
        return matrix;
    }
}