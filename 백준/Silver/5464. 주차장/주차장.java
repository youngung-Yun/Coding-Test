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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // -1 = 비어있음
        int[] parkingLots = new int[n];
        Arrays.fill(parkingLots, -1);
        int[] fees = new int[n];
        for (int i = 0; i < n; i++) {
            fees[i] = Integer.parseInt(br.readLine());
        }
        int[] cars = new int[m+1];
        for (int i = 1; i <= m; i++) {
            cars[i] = Integer.parseInt(br.readLine());
        }
        int[] parkingLotNumber = new int[m+1];

        Deque<Integer> waiting = new ArrayDeque<>();
        int totalFee = 0;
        for (int i = 0; i < 2 * m; i++) {
            int command = Integer.parseInt(br.readLine());
            // 자동차 들어옴
            if (command > 0) {
                int emptyParkingLot = findEmptyParkingLot(parkingLots);
                // 비어있는 주차장 없음
                if (emptyParkingLot == -1) {
                    waiting.offerLast(command);
                } else {
                    totalFee += fees[emptyParkingLot] * cars[command];
                    parkingLots[emptyParkingLot] = command;
                    parkingLotNumber[command] = emptyParkingLot;
                }
            } else {
                // 자동차 나감
                int carNumber = -command;
                int number = parkingLotNumber[carNumber];
                parkingLots[number] = -1;
                if (!waiting.isEmpty()) {
                    int now = waiting.removeFirst();
                    totalFee += fees[number] * cars[now];
                    parkingLots[number] = now;
                    parkingLotNumber[now] = number;
                }
            }
        }
        System.out.println(totalFee);
    }

    static int findEmptyParkingLot(int[] parkingLots) {
        for (int i = 0; i < parkingLots.length; i++) {
            if (parkingLots[i] == -1) {
                return i;
            }
        }
        return -1;
    }
}