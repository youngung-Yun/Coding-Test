import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int mileage = Integer.parseInt(st.nextToken());
        int[] minMileages = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            if (p < l) {
                minMileages[i] = 1;
                continue;
            }
            minMileages[i] = array[p - l];
        }
        Arrays.sort(minMileages);
        int result = 0;
        while (result < n && mileage >= minMileages[result]) {
            mileage -= minMileages[result];
            ++result;
        }
        System.out.println(result);
    }
}
