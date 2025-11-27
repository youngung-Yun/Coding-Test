import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int state = 0;

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];

            if (command.equals("add")) {
                int x = Integer.parseInt(input[1]);
                state |= 1 << (x - 1);
            }
            else if (command.equals("remove")) {
                int x = Integer.parseInt(input[1]);
                state &= ~(1 << (x - 1));
            }
            else if (command.equals("check")) {
                int x = Integer.parseInt(input[1]);   
                if ((state & (1 << (x - 1))) != 0) { // x 존재
                    sb.append(1).append('\n');
                }
                else {
                    sb.append(0).append('\n');
                }
            }
            else if (command.equals("toggle")) {
                int x = Integer.parseInt(input[1]);
                state ^= 1 << (x - 1);
            }
            else if (command.equals("all")) {
                state = ~0;
            }
            else {
                state = 0;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
