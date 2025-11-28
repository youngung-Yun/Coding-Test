import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] visited = new boolean[101][101];


        for (int i = 0; i < 4; i++) {
            String[] point = br.readLine().split(" ");
            int minX = Integer.parseInt(point[0]);
            int minY = Integer.parseInt(point[1]);
            int maxX = Integer.parseInt(point[2]);
            int maxY = Integer.parseInt(point[3]);

            for (int nx = minX; nx < maxX; nx++) {
                for (int ny = minY; ny < maxY; ny++) {
                    visited[nx][ny] = true;
                }
            }
        }
        int count = 0;
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                if (visited[i][j]) {
                    ++count;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}