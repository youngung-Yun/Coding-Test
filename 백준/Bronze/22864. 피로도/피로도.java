import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tired = Integer.parseInt(st.nextToken());
        int task = Integer.parseInt(st.nextToken());
        int rest = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        int completedTask = 0;
        int currentTired = 0;
        for (int h = 0; h < 24; h++) {
            // 휴식
            if (currentTired + tired > limit) {
                currentTired = Integer.max(currentTired - rest, 0);
            } else {
                // 작업
                currentTired += tired;
                completedTask += task;
            }
        }
        System.out.println(completedTask);
    }
}
