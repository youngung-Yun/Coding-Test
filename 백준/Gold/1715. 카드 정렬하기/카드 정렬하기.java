import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> cards = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(bf.readLine()));
        }

        int ans = 0;
        while (cards.size() > 1) {
            int newCards = cards.poll() + cards.poll();
            ans += newCards;
            cards.add(newCards);
        }

        System.out.println(ans);
    }
}