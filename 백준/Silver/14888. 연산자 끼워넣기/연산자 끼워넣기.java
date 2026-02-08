import java.io.*;
import java.util.*;

public class Main {
    
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // [0] = +, [1] = -, [2] = *, [3] = /
        int[] operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(array, array[0], 1, n, operators);

        System.out.println(max);
        System.out.print(min);
    }

    private static void dfs(int[] array, int curr, int index, int length, int[] opers) {
        if (index == length) {
            max = Math.max(max, curr);
            min = Math.min(min, curr);
            return;
        }

        for (int i = 0; i < opers.length; i++) {
            if (opers[i] > 0) {
                --opers[i];
                if (i == 0) { // 덧셈
                    dfs(array, curr + array[index], index + 1, length, opers);
                }
                else if (i == 1) { // 뺄셈
                    dfs(array, curr - array[index], index + 1, length, opers);
                }
                else if (i == 2) { // 곱셈
                    dfs(array, curr * array[index], index + 1, length, opers);         
                }
                else { // 나눗셈
                    dfs(array, curr / array[index], index + 1, length, opers);               
                }
                ++opers[i];
            }
        }
    }
}
