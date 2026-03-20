import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(bf.readLine());
        int[] coord = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            coord[i] = Integer.parseInt(stk.nextToken());
        }
        int[] time = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(stk.nextToken());
        }

        // [coord, time]
        int[][] parcels = new int[n][2];
        for (int i = 0; i < n; i++) {
            parcels[i][0] = coord[i];
            parcels[i][1] = time[i];
        }

        // 가장 멀리 있는 택배부터
        Arrays.sort(parcels, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p1[1], p2[1]);
            } else {
                return Integer.compare(p2[0], p1[0]);
            }
        });

        int currentCoord = parcels[0][0];
        int currentTime = currentCoord;

        for (int[] parcel : parcels) {
            currentTime += (currentCoord - parcel[0]);
            currentCoord = parcel[0];
            if (currentTime < parcel[1]) {
                currentTime = parcel[1];
            }
        }

        currentTime += currentCoord;

        System.out.println(currentTime);
    }
}