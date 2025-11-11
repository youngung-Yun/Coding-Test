import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int[] prefixSum = new int[n];
        prefixSum[0] = array[0];

        int total = prefixSum[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i];
            total += prefixSum[i];
        }

        System.out.println(total);
    }

}
