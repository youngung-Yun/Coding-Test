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

        int minPrice = 0;
        if (eachMin * 6 < bulkMin) {
            minPrice = eachMin * n;
        } else {
            int bulkCount = n / 6;
            int expectedPrice = bulkCount * bulkMin + (n - (bulkCount * 6)) * eachMin;
            int onlyBulk = (bulkCount + 1) * bulkMin;
            minPrice = Math.min(expectedPrice, onlyBulk);
        }

        System.out.println(minPrice);
    }
}