
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());
        Item[] items = new Item[n+1];
        items[0] = new Item(0, 0);
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            items[i] = new Item(weight, value);
        }

        int[][] dp = new int[n+1][capacity+1];
        for (int i = 1; i <= n; i++) {
            Item item = items[i];
            for (int w = 1; w <= capacity; w++) {
                if (w < item.weight) {
                    dp[i][w] = dp[i-1][w];
                } else {
                    dp[i][w] = Integer.max(dp[i-1][w], dp[i-1][w - item.weight] + item.value);
                }
            }
        }
        System.out.println(dp[n][capacity]);
    }


    static class Item {
        public int weight;
        public int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}