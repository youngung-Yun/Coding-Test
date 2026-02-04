import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[][] paper = new boolean[101][101];
        int n = Integer.parseInt(buffer.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            for (int r = x; r < x + 10; r++) {
                for (int c = y; c < y + 10; c++) {
                    paper[r][c] = true;
                }
            }
        }
        int area = 0;
        for (boolean[] row : paper) {
            for (boolean col : row) {
                area += col ? 1 : 0;
            }
        }
        System.out.println(area);
    }
}
