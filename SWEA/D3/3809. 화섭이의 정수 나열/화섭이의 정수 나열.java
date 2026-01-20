import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            StringBuilder tmp = new StringBuilder();
            for (int e : array) {
                tmp.append(e);
            }
            int number = 0;
            while (tmp.indexOf(String.valueOf(number)) != -1) {
                ++number;
            }
            sb.append('#').append(testCase).append(' ').append(number).append('\n');
        }
        System.out.println(sb);
    }

}