import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[][] moves = new int[6][2];
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            moves[i] = new int[]{direction, distance};
        }

        int area = 0;
        int exclude = 0;
        for (int i = 0; i < 6; i++) {
            if (moves[i][0] == moves[(i + 2) % 6][0] && moves[(i + 1) % 6][0] == moves[(i + 3) % 6][0]) {
                area = moves[(i - 1 + 6) % 6][1] * moves[(i - 2 + 6) % 6][1];
                exclude = moves[(i + 1) % 6][1] * moves[(i + 2) % 6][1];
                break;
            }
        }

        System.out.println(k * (area - exclude));
    }
}
