import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] paint = new int[100][100];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());
            for (int r = sx - 1; r < dx; ++r) {
                for (int c = sy - 1; c < dy; ++c) {
                    ++paint[r][c];
                }
            }
        }
        long count = Arrays.stream(paint).flatMapToInt(Arrays::stream).filter(e -> e > m).count();
        System.out.println(count);
    }
}