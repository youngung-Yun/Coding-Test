import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int weightLimit = Integer.parseInt(st.nextToken());
        int[] trucks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            bridge.offerLast(0);
        }
        int time = 0;
        int currentWeight = 0;
        int acrossCount = 0;
        int index = 0;

        while (acrossCount < n) {
            ++time;
            // 도착한 트럭 지나감
            if (bridge.peekFirst() != 0) {
                ++acrossCount;
            }
            currentWeight -= bridge.removeFirst();

            // 남아있는 트럭이 있으며 하중이 버틸 수 있음
            if (index < n && currentWeight + trucks[index] <= weightLimit) {
                currentWeight += trucks[index];
                bridge.offerLast(trucks[index]);
                ++index;
            }
            // 하중이 버틸 수 없으면 0을 큐에 삽입
            else {
                bridge.offerLast(0);
            }
        }

        System.out.println(time);
    }
}
