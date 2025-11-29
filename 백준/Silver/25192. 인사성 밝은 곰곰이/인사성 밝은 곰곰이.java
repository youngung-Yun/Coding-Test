import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        /*
         * 채팅치면 Set에 닉네임 저장
         * 누군가 들어오면 Set의 사이즈 더하고 Set 리셋
         */
        Set<String> set = new HashSet<>();
        int total = 0;
        for (int i = 0; i < n; i++) {
            String chat = br.readLine();
            if (chat.equals("ENTER")) {
                total += set.size();
                set.clear();
            }
            else {
                set.add(chat);
            }
        }
        total += set.size();

        System.out.println(total);
    }
}