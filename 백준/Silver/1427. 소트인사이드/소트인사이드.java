import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String number = br.readLine();
        int[] array = new int[number.length()];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Character.getNumericValue(number.charAt(i));
        }

        for (int i = 0; i < array.length - 1; ++i) {
            int maxIdx = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[maxIdx] < array[j]) {
                    maxIdx = j;
                }
            }
            int temp = array[maxIdx];
            array[maxIdx] = array[i];
            array[i] = temp;
        }

        for (int n : array) {
            sb.append(n);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}