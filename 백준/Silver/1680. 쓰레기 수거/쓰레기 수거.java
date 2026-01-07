import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int limitWeight = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            Trash[] trashes = new Trash[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int distance = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());
                trashes[i] = new Trash(distance, amount);
            }
            int totalDistance = 0;
            int currentWeight = 0;
            boolean isInGarbageDump = true;
            int target = 0;
            while (target < n) {
                // 현재 쓰레기장이면 다음 지점으로 이동
                if (isInGarbageDump) {
                    currentWeight = 0;
                    totalDistance += trashes[target].distance;
                    isInGarbageDump = false;
                    continue;
                }

                // 현재 쓰레기 실었을 때 용량 초과 시 쓰레기장으로 이동
                if (currentWeight + trashes[target].amount > limitWeight) {
                    totalDistance += trashes[target].distance;
                    isInGarbageDump = true;
                    continue;
                }
                currentWeight += trashes[target].amount;
                // 용량 다 채웠거나 마지막 지점이면 쓰레기장으로 이동
                if (currentWeight == limitWeight || target == n - 1) {
                    totalDistance += trashes[target].distance;
                    ++target;
                    isInGarbageDump = true;
                } else if (currentWeight < limitWeight) {
                    // 용량 남으면 다음 지점으로
                    totalDistance += (trashes[target+1].distance - trashes[target].distance);
                    ++target;
                }
            }
            sb.append(totalDistance).append('\n');
        }
        System.out.println(sb);
    }

    private static class Trash {
        public int distance;
        public int amount;

        public Trash(int distance, int amount) {
            this.distance = distance;
            this.amount = amount;
        }
    }
}