import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = sc.nextInt();
            int[] mountains = new int[n];
            for (int i = 0; i < n; i++) {
                mountains[i] = sc.nextInt();
            }

            int[] lowerCount = getLowerMountainsCount(mountains, n);
            int[] higherCount = getHigherMountainsCount(mountains, n);

            long ans = 0L;
            for (int i = 0; i < n; i++) {
                ans += lowerCount[i] * higherCount[i];
            }
            System.out.println("#" + testCase + " " + ans);
        }
    }

    static int[] getLowerMountainsCount(int[] arr, int n) {
        int[] result = new int[n];
        result[0] = 0;
        for (int i = 1 ; i < n; i++) {
            if (arr[i] > arr[i-1]) {
                result[i] = result[i-1] + 1;
            }
        }
        return result;
    }
    static int[] getHigherMountainsCount(int[] arr, int n) {
        int[] result = new int[n];
        result[n-1] = 0;
        for (int i = n - 2 ; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                result[i] = result[i+1] + 1;
            }
        }
        return result;
    }

}
