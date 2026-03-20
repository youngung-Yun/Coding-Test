import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] myCards = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int[] opponentCards = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        // 이기려면 (n/2)+1장 이상의 카드가, 사장이 그보다 큰 카드를 가지고 있어야 함
        for (int i = 0; i <= n / 2; i++) {
            if (myCards[n/2-i] >= opponentCards[n-1-i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}