import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] ground = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int height = Integer.parseInt(row[j]);
                ground[i][j] = height;
            }
        }
        int minTime = Integer.MAX_VALUE;
        int optimalHeight = 0;
        // i는 땅의 높이
        for (int i = 0; i <= 256; i++) {
            int deleteCount = 0;
            int addCount = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    int currentHeight = ground[row][col];
                    if (i >= currentHeight) {
                        addCount += i - currentHeight;
                    } else {
                        deleteCount += currentHeight - i;
                    }
                }
            }
            if (addCount > b + deleteCount) {
                break;
            }
            int totalTime = deleteCount * 2 + addCount;
            if (minTime >= totalTime) {
                minTime = totalTime;
                optimalHeight = i;
            }
        }
        System.out.println(minTime + " " + optimalHeight);
    }
}
