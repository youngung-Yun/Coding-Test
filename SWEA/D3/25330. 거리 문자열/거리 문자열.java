
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++) {
            List<List<Integer>> numberIndices = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                numberIndices.add(new ArrayList<>());
            }
            String n = sc.next();
            for (int i = 0; i < n.length(); i++) {
                char ch = n.charAt(i);
                int digit = Character.getNumericValue(ch);
                numberIndices.get(digit).add(i);
            }

            boolean isFulfilled = true;
            for (int i = 0; i < 10; i++) {
                List<Integer> indices = numberIndices.get(i);
                if (indices.size() == 0) {
                    continue;
                } else if (indices.size() == 2 && (indices.get(1) - indices.get(0) - 1 == i)) {
                    continue;
                } else {
                    isFulfilled = false;
                    break;
                }
            }
            if (isFulfilled) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.println(sb);
    }
}