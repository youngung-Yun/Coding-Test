import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] matrixA = new int[n][m];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < m; c++) {
                matrixA[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        stk = new StringTokenizer(bf.readLine());
        int i = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int[][] matrixB = new int[i][k];
        for (int r = 0; r < i; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < k; c++) {
                matrixB[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        int outerRow = n;
        int inner = m;
        int outerCol = k;

        int[][] result = multiplyMatrix(matrixA, matrixB, outerRow, inner, outerCol);

        StringBuilder sb = new StringBuilder();
        for (int[] row : result) {
            for (int col : row) {
                sb.append(col).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int[][] multiplyMatrix(int[][] a, int[][] b, int outerRow, int inner ,int outerCol) {
        int[][] result = new int[outerRow][outerCol];

        for (int r = 0; r < outerRow; r++) {
            for (int c = 0; c < outerCol; c++) {
                int sum = 0;
                for (int i = 0; i < inner; i++) {
                    sum += (a[r][i] * b[i][c]);
                }
                result[r][c] = sum;
            }
        }

        return result;
    }
}