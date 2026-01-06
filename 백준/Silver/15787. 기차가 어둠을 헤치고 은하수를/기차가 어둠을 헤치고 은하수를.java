import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trains = new int[n];
        for (int i = 0; i < m; i++) {
            String[] command = br.readLine().split(" ");
            int trainNumber = Integer.parseInt(command[1]);
            int x;
            switch (command[0]) {
                case "1":
                    x = Integer.parseInt(command[2]);
                    trains[trainNumber-1] |= (0b1 << (x - 1));
                    break;
                case "2":
                    x = Integer.parseInt(command[2]);
                    trains[trainNumber-1] &= ~(0b1 << (x - 1));
                    break;
                case "3":
                    trains[trainNumber-1] = trains[trainNumber-1] << 1;
                    // 20 번째 이후로 값 제거
                    trains[trainNumber-1] &= ~(0b1 << 20);
                    break;
                case "4":
                    trains[trainNumber-1] = trains[trainNumber-1] >>> 1;
                    break;
            }
        }
        Set<Integer> canAcrossTrains = new HashSet<>();
        for (int train : trains) {
            canAcrossTrains.add(train);
        }
        System.out.println(canAcrossTrains.size());
    }
}