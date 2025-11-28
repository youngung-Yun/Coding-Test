import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }


        int count = 0;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (true) {
            if (sum < m) {
                sum += array[end++];
            } else if (sum == m) {
                ++count;
                sum -= array[start++];
            } else {
                sum -= array[start++];
            }

            if (end >= n && sum < m) {
                break;
            }
        }

        System.out.println(count);
        br.close();
    }
}
