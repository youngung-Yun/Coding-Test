import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNumbers = new String[n];
            for (int i = 0; i < n; i++) {
                phoneNumbers[i] = br.readLine();
            }
            Arrays.sort(phoneNumbers);
            Node ROOT = new Node();
            boolean isConsistent = true;
            for (int i = 0; i < n; i++) {
                if (!isConsistent) {
                    break;
                }
                Node current = ROOT;
                for (char ch : phoneNumbers[i].toCharArray()) {
                    int index = Character.getNumericValue(ch);
                    if (current.children[index] == null) {
                        Node newNode = new Node();
                        current.children[index] = newNode;
                        current = newNode;
                    } else {
                        if (current.children[index].isEnd) {
                            isConsistent = false;
                            break;
                        }
                        current = current.children[index];
                    }
                }
                current.isEnd = true;
            }

            if (isConsistent) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static class Node {
        public Node[] children;
        public boolean isEnd;

        {
            children = new Node[10];
            isEnd = false;
        }
    }
}