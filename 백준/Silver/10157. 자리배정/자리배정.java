import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(br.readLine());

        if ((long) width * height < k) {
            System.out.println(0);
            return;
        }
        int[][] direction = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        boolean[][] visited = new boolean[height + 1][width + 1];
        int nh = 1;
        int nw = 1;
        int seq = 1;
        int idx = 0;
        visited[nh][nw] = true;
        while (seq < k) {
            // 다음 칸
            int dh = nh + direction[idx][0];
            int dw = nw + direction[idx][1];

            // 범위 벗어나거나 이미 있는 칸이면 다음 방향으로
            while (true) {
                if (dh <= 0 || dw <= 0 || dh > height || dw > width) {
                    idx = (idx + 1) % 4;
                    dh = nh + direction[idx][0];
                    dw = nw + direction[idx][1];
                    continue;
                }
                if (visited[dh][dw]) {
                    idx = (idx + 1) % 4;
                    dh = nh + direction[idx][0];
                    dw = nw + direction[idx][1];
                    continue;
                }
                break;
            }
            nh = dh;
            nw = dw;
            visited[nh][nw] = true;
            ++seq;
        }
        System.out.println(nw + " " + nh);
    }
}