import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String expression = bf.readLine();
        int idx = expression.indexOf('x');
        if (idx == -1) {
            System.out.println(0);
        } else if (idx == 0) {
            System.out.println(1);
        } else if (idx == 1 && expression.charAt(0) == '-') {
            System.out.println(-1);
        } else {
            System.out.println(Integer.parseInt(expression.substring(0, idx)));
        }
    }
}