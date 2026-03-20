import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(bf.readLine());
        int[] home = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(stk.nextToken());
        }
        int[] time = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(stk.nextToken());
        }

        // 각 위치의 택배 받는 시간 = max(abs(위치 - 현재위치), (시간 - 현재시간))
        // 이게 가장 작은 집부터 방문

        int currentTime = 0;
        int currentCoord = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for (int k = 0; k < n; k++) {
                if (visited[k]) {
                    continue;
                }
                int elapsed = Integer.max(Math.abs(currentCoord - home[k]), (time[k] - currentTime));
                if (min > elapsed) {
                    min = elapsed;
                    idx = k;
                }
            }
            visited[idx] = true;
            currentTime += min;
            currentCoord = home[idx];
        }

        currentTime += currentCoord;

        System.out.println(currentTime);
    }
}