import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initialMoney = Integer.parseInt(br.readLine());
        int[] stocks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int junhyeonStock = 0;
        int junhyeonMoney = initialMoney;
        for (int stock : stocks) {
            junhyeonStock += (junhyeonMoney / stock);
            junhyeonMoney %= stock;
        }

        int seongminStock = 0;
        int seongminMoney = initialMoney;
        for (int i = 0; i < stocks.length; i++) {
            if (i <= 2) {
                continue;
            }

            if (stocks[i-1] > stocks[i-2] && stocks[i-2] > stocks[i-3]) {
                seongminMoney += seongminStock * stocks[i];
                seongminStock = 0;

            } else if (stocks[i-1] < stocks[i-2] && stocks[i-2] < stocks[i-3]) {
                seongminStock += (seongminMoney / stocks[i]);
                seongminMoney %= stocks[i];
            }
        }

        int junhyeonAsset = junhyeonMoney + (junhyeonStock * stocks[13]);
        int seongminAsset = seongminMoney + (seongminStock * stocks[13]);
        if (junhyeonAsset > seongminAsset) {
            System.out.println("BNP");
        } else if (junhyeonAsset < seongminAsset) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}