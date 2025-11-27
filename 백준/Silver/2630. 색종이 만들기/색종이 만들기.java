import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static int white = 0;
    private static int blue = 0;

    // 0 = 하얀색
    // 1 = 파란색

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(row[j]);
            }
        }

        recursion(paper, 0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void recursion(int[][] paper, int x, int y, int length) {
        int color = paper[x][y];
        boolean canSquare = true;
        A: for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (paper[i][j] != color) {
                    canSquare = false;
                    int half = length / 2;

                    recursion(paper, x, y, half);
                    recursion(paper, x + half, y, half);
                    recursion(paper, x, y + half, half);
                    recursion(paper, x + half, y + half, half);

                    break A;
                }
            }
        }
        if (canSquare) {
            if (color == 0) {
                ++white;
            } else {
                ++blue;
            }
        }
    }
}