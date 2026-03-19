import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int budget = Integer.parseInt(stk.nextToken());
        int discount = Integer.parseInt(stk.nextToken());

        int[] gift = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            gift[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(gift);

        // 현재까지 구매한 선물 중 세일 안받은 선물을 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p2, p1));
        int pay = 0;
        int count = 0;
        for (int g : gift) {
            pay += g;
            pq.add(g);
            // 가격이 예산 초과면 세일 가능한동안 비싼 선물부터 세일
            while (pay > budget && discount > 0 && !pq.isEmpty()) {
                pay -= (pq.poll()) / 2;
                --discount;
            }
            // 그래도 못넘으면 종료
            if (pay > budget) {
                break;
            }
            ++count;
        }

        System.out.println(count);
    }

}