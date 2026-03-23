import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] minNutrients;
    static int[][] ingredients;

    static int minPrice = 15 * 500 + 1;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        minNutrients = new int[4];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            minNutrients[i] = Integer.parseInt(stk.nextToken());
        }

        ingredients = new int[n][5];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            for (int k = 0; k < 5; k++) {
                ingredients[i][k] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int bitmask = 1; bitmask < (0b1 << n); bitmask++) {
            compute(bitmask);
        }

        StringBuilder sb = new StringBuilder();
        if (list.size() == 0) {
            System.out.println(-1);
            return;
        }

        sb.append(minPrice).append('\n');
        for (int e : list) {
            sb.append(e + 1).append(' ');
        }
        System.out.println(sb);
    }

    static void compute(int bitmask) {
        int[] nutrients = new int[4];
        int price = 0;
        for (int i = 0; i < n; i++) {
            if ((bitmask & (0b1 << i)) == 0) {
                continue;
            }
            for (int k = 0; k < 4; k++) {
                nutrients[k] += ingredients[i][k];
            }
            price += ingredients[i][4];
        }

        for (int i = 0; i < 4; i++) {
            if (minNutrients[i] > nutrients[i]) {
                return;
            }
        }

        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((bitmask & (0b1 << i)) != 0) {
                tmp.add(i);
            }
        }
        if (minPrice > price || (minPrice == price && isAhead(tmp))) {
            minPrice = price;
            list = tmp;
        }
    }

    static boolean isAhead(List<Integer> tmp) {
        int n = Integer.min(list.size(), tmp.size());
        for (int i = 0; i < n; i++) {
            if (tmp.get(i) < list.get(i)) {
                return true;
            } else if (tmp.get(i) > list.get(i)) {
                return false;
            }
        }

        return tmp.size() < list.size();
    }
}