import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brackets = br.readLine();
        int l = brackets.length();
        int[] frontLegs = new int[l];
        for (int i = l - 2; i >= 0; i--) {
            if (brackets.charAt(i) == ')' && brackets.charAt(i + 1) == ')') {
                frontLegs[i] = frontLegs[i+1] + 1;
            } else {
                frontLegs[i] = frontLegs[i+1];
            }
        }
        int result = 0;
        for (int i = 1; i < l; i++) {
            if (brackets.charAt(i) == '(' && brackets.charAt(i - 1) == '(') {
                result += frontLegs[i];
            }
            }
        System.out.println(result);
    }
}