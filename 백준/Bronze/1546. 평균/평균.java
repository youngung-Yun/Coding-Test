import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] grades = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int largest = grades[0];
        int total = 0;
        for (int grade : grades) {
            largest = Math.max(largest, grade);
            total += grade;
        }

        double newArg = total / (double) largest * 100.0 / n;

        System.out.println(newArg);
    }
}