import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, n -1, array, new int[n]);

        for (int i = 0; i < n; ++i) {
            sb.append(array[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void mergeSort(int start, int end, int[] array, int[] temp) {
        if (start >= end) {
            return;
        }
        int center = (start + end) / 2;
        mergeSort(start, center, array, temp);
        mergeSort(center + 1, end, array, temp);

        int leftIndex = start;
        int rightIndex = center + 1;
        int tempIndex = 0;
        while (leftIndex < center + 1 && rightIndex <= end) {
            if (array[leftIndex] > array[rightIndex]) {
                temp[tempIndex++] = array[rightIndex++];
            }
            else {
                temp[tempIndex++] = array[leftIndex++];

            }
        }
        while (leftIndex < center + 1) {
            temp[tempIndex++] = array[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[tempIndex++] = array[rightIndex++];
        }
        tempIndex = 0;
        while (start + tempIndex <= end) {
            array[start + tempIndex] = temp[tempIndex];
            tempIndex++;
        }
    }
}