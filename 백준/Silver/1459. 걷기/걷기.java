import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long min = Long.min(x, y);
        long max = Long.max(x, y);
        long diff = max - min;
        // (min, min) 까지는 2*w와 s 중 덜 걸리는 쪽 선택
        // (min, min)부터 (max, max) 까지는 2칸 씩 w와 s중 덜 걸리는 쪽 선택. 홀수면 남은 1칸은 무조건 w

        long result = Long.min(2 * w, s) * min;
        if (diff % 2 == 0) {
            result += Long.min(w, s) * diff;
        } else {
            result += Long.min(w, s) * (diff - 1) + w;
        }
        System.out.println(result);
    }

}
