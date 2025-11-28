import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String word = br.readLine();

        String replaced = document.replace(word, "");

        System.out.println((document.length() - replaced.length()) / word.length());

        br.close();
    }
}