import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int bulkMin = 1_001;
        int eachMin = 1_001;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int bulk = Integer.parseInt(st.nextToken());
            int each = Integer.parseInt(st.nextToken());
            bulkMin = Math.min(bulkMin, bulk);
            eachMin = Math.min(eachMin, each);
        }

        int minPrice = eachMin * n;
        for (int i = 0; i <= (int) Math.ceil(1.0 * n / 6.0); i++) {
            int totalPrice = (i * bulkMin) + (Math.max(0, n - (i * 6)) * eachMin);
            minPrice = Math.min(minPrice, totalPrice);
        }
        System.out.println(minPrice);
    }
}