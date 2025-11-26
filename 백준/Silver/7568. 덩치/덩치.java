import java.io.*;
import java.util.*;

public class Main {
    
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][2];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            array[i] = new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])};
        }

        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int k = 0; k < n; k++) {
                // 나보다 덩치 큰 사람
                if (array[i][0] < array[k][0] && array[i][1] < array[k][1]) {
                    ++count;
                }
            } 
            sb.append(count).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
