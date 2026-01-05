import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] maxPrices = new int[m];
        for (int i = 0; i < m; i++) {
            maxPrices[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(maxPrices);
        int price = 1_000_001;
        int income = 0;
        for (int i = 0; i < m; i++) {
            // maxPrices[i] 가격으로 총 min(m-i, n)명이 구입
            int total = maxPrices[i] * Integer.min(n, m - i);
            if (income < total) {
                price = maxPrices[i];
                income = total;
            }
        }
        System.out.println(price + " " + income);
    }
}

