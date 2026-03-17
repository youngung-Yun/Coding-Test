import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n;
    private static boolean canMake = false;
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        map.put(0, 6);
        map.put(1, 2);
        map.put(2, 5);
        map.put(3, 5);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 3);
        map.put(8, 7);
        map.put(9, 6);

        n = Integer.parseInt(bf.readLine());

        permutation(new int[6], 0);

        if (!canMake) {
            System.out.println("impossible");
        }
    }

    private static void permutation(int[] arr, int depth) {
        if (canMake) {
            return;
        }

        if (depth == 6) {
            if (checkCount(arr) && isCorrect(arr)) {
                canMake = true;
                System.out.printf("%d%d+%d%d=%d%d\n", arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
            }
            return;
        }

        for (int digit = 0; digit <= 9; digit++) {
            arr[depth] = digit;
            permutation(arr, depth + 1);
        }
    }

    private static boolean checkCount(int[] arr) {
        int sum = 0;
        for (int e : arr) {
            sum += map.get(e);
        }
        return sum + 4 == n;
    }

    private static boolean isCorrect(int[] arr) {
        int a = arr[0] * 10 + arr[1];
        int b = arr[2] * 10 + arr[3];
        int result = arr[4] * 10 + arr[5];
        return a + b == result;
    }
}