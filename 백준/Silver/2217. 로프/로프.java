import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];
        for (int i = 0; i < n; i++) {
            int weight = Integer.parseInt(br.readLine());
            ropes[i] = weight;
        }
        Arrays.sort(ropes);

        /*
        k개의 로프가 버틸 수 있는 최대 무게 = 
        min(ropes) * size(ropes)
        하중이 작은 로프를 하나씩 빼가며 비교
         */
        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = n - i;
            int leastWeight = ropes[i];
            max = Math.max(max, leastWeight * count);
        }
        System.out.println(max);
        br.close();
    }
}