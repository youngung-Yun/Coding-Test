import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int answer = -1;
        int max5kgCount = n / 5;

        while (max5kgCount >= 0) {
            int leftSugar = n - max5kgCount * 5;
            if (leftSugar % 3 == 0) {
                answer = max5kgCount + leftSugar / 3;
                break;
            }
            max5kgCount--;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }

}   