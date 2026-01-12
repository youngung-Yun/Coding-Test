import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        double l = Double.parseDouble(st.nextToken());
        double w = Double.parseDouble(st.nextToken());
        double h = Double.parseDouble(st.nextToken());

        // 박스에 넣을 수 있는 최대 개수 = (l // a) * (w // a) * (h // a)
        // upper bound
        double low = 1e-9;
        double high = Double.min(l, Double.min(w, h));
        for (int i = 0; i < 5_000; i++) {
            if (high - low < 1e-9) {
                break;
            }
            double mid = low + (high - low) / 2.0;
            long count = computeMaxCount(mid, l, w, h);
            // count가 더 작으면 박스 크기를 줄여야 함
            if (count >= n) {
                low = mid;
            } else {
                high = mid;
            }
        }
        System.out.println(low);
    }

    static long computeMaxCount(double size, double l, double w, double h) {
        long count = 1L;
        count *= (long) (l / size);
        count *= (long) (w / size);
        count *= (long) (h / size);
        return count;
    }
}