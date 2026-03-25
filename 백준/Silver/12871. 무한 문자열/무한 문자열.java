import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String a = bf.readLine();
        String b = bf.readLine();

        StringBuilder aBuilder = new StringBuilder();
        StringBuilder bBuilder = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            aBuilder.append(a);
        }
        for (int i = 0; i < a.length(); i++) {
            bBuilder.append(b);
        }

        if (aBuilder.toString().equals(bBuilder.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}