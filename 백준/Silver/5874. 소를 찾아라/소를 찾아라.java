import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brackets = br.readLine();
        int l = brackets.length();
        int[] backLegs = new int[l];
        int[] frontLegs = new int[l];
        for (int i = 1; i < l; i++) {
            if (brackets.charAt(i) == '(' && brackets.charAt(i - 1) == '(') {
                backLegs[i] = backLegs[i-1] + 1;
            } else {
                backLegs[i] = backLegs[i-1];
            }
            if (brackets.charAt(i) == ')' && brackets.charAt(i - 1) == ')') {
                frontLegs[i] = frontLegs[i-1] + 1;
            } else {
                frontLegs[i] = frontLegs[i-1];
            }
        }
        int result = 0;
        int current = 0;
        for (int i = 1; i < l; i++) {
            if (current < backLegs[i]) {
                result += frontLegs[l-1] - frontLegs[i + 1];
                current = backLegs[i];
            }
        }
        System.out.println(result);
    }
}