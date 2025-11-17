import java.util.Scanner;

class Main
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        char curr = s.charAt(0);
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != curr) {
                curr = s.charAt(i);
                ++count;
            }
        }
        ++count;

        System.out.println(count / 2);
    }
}
