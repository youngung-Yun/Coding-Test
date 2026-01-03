import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char[] initials = new char[] {'U', 'C', 'P', 'C'};
        int index = 0;
        for (char ch : word.toCharArray()) {
            if (index >= 4) {
                break;
            }
            if (ch == initials[index]) {
                ++index;
            }
        }
        if (index >= 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }

}
