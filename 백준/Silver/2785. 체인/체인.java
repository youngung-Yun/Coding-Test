import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] chains = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(chains);
        int minIdx = 0;
        int maxIdx = n - 1;
        int result = 0;
        while (minIdx < maxIdx) {
            --chains[minIdx];
            --maxIdx;
            ++result;
            if (chains[minIdx] == 0) {
                ++minIdx;
            }
        }
        System.out.println(result);
    }
}
