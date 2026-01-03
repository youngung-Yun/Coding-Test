import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 공은 최소 (1 + 2 + 3 + ... + K)개 필요함
        // 이보다 적으면 나눠 담을 수 없음
        int count = (k * (k + 1)) / 2;
        if (n < count) {
            System.out.println(-1);
        // N이 1씩 증가하는 K의 등차수열로 나타낼 수 있으면((N - count) % k == 0) 개수 차이는 N - 1개
        } else if ((n - count) % k == 0) {
            System.out.println(k - 1);
        // 그게 아니면 조건을 만족하는 가장 큰 수열에서 큰 수를 나머지 m개를 1씩 증가시켜야함
        // 개수 차이는 N개
        } else {
            System.out.println(k);
        }
    }
}
