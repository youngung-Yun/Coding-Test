import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            int normalCount = 0;
            for (int i = 1; i < n - 1; i++) {

                int max = getMax(array[i-1], array[i], array[i+1]);
                int min = getMin(array[i-1], array[i], array[i+1]);
                if (array[i] != max && array[i] != min) {
                    ++normalCount;
                }
            }
            sb.append('#').append(testCase).append(' ').append(normalCount).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    static int getMax(int a, int b, int c) {
        return Integer.max(a, Integer.max(b, c));
    }

    static int getMin(int a, int b, int c) {
        return Integer.min(a, Integer.min(b, c));
    }
}