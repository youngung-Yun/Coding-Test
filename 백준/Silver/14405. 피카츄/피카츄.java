import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();

        str = str.replace("pi", "!").replace("ka", "@").replace("chu", "#");
        boolean flag = true;
        for (char ch : str.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }
}