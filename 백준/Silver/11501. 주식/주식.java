import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] stocks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long profit = 0L;
            int highestStock = 0;
            // 현재 가격이 highestStock보다 낮다: 사서 highestStock 날에 팔기
            // 높다: highestStock 갱신
            for (int i = n - 1; i >= 0; i--) {
                int currentStock = stocks[i];
                if (currentStock <= highestStock) {
                    profit += (highestStock - currentStock);
                } else {
                    highestStock = currentStock;
                }
            }
            sb.append(profit).append('\n');
        }
        System.out.println(sb.toString());
    }
}
