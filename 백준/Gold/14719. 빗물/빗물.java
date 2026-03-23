import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int h = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());
        int[][] grid = new int[h][w];

        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < w; i++) {
            int height = Integer.parseInt(stk.nextToken());
            for (int k = 0; k < height; k++) {
                grid[k][i] = 1;
            }
        }

        int ans = 0;
        for (int height = 0; height < h; height++) {
            int wall = -1;
            for (int width = 0; width < w; width++) {
                if (grid[height][width] == 0) {
                    continue;
                }
                if (wall != -1) {
                    ans += (width - wall - 1);
                }
                wall = width;
            }
        }
        System.out.println(ans);
    }
}