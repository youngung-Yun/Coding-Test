import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int highestFloor = Integer.parseInt(st.nextToken());
        int startFloor = Integer.parseInt(st.nextToken());
        int targetFloor = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        int[] counts = new int[highestFloor + 1];
        Arrays.fill(counts, -1);
        counts[startFloor] = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(startFloor);
        while (counts[targetFloor] == -1 && !queue.isEmpty()) {
            int currentFloor = queue.removeFirst();

            int downFloor = currentFloor - down;
            if (downFloor > 0 && counts[downFloor] == -1) {
                queue.offerLast(downFloor);
                counts[downFloor] = counts[currentFloor] + 1;
            }
            int upFloor = currentFloor + up;
            if (upFloor <= highestFloor && counts[upFloor] == -1) {
                queue.offerLast(upFloor);
                counts[upFloor] = counts[currentFloor] + 1;
            }
        }
        System.out.println(counts[targetFloor] == -1 ? "use the stairs" : counts[targetFloor]);
    }
}
