import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= 10; testCase++) {
            int n = Integer.parseInt(br.readLine());
            String[] ciphers = br.readLine().split(" ");
            DoublyLinkedList list = new DoublyLinkedList();
            for (String cipher : ciphers) {
                list.append(cipher);
            }

            int m = Integer.parseInt(br.readLine());
            int commandIdx = 0;
            String[] commands = br.readLine().split(" ");
            while (commandIdx < commands.length) {
                if (commands[commandIdx].equals("I")) {
                    int x = Integer.parseInt(commands[++commandIdx]);
                    int y = Integer.parseInt(commands[++commandIdx]);
                    String[] insert = new String[y];
                    for (int i = 0; i < y; i++) {
                        insert[i] = commands[++commandIdx];
                    }
                    for (int i = y - 1; i >= 0; --i) {
                        list.insert(x, insert[i]);
                    }

                } else if (commands[commandIdx].equals("D")) {
                    int x = Integer.parseInt(commands[++commandIdx]);
                    int y = Integer.parseInt(commands[++commandIdx]);
                    for (int i = 0; i < y; i++) {
                        list.remove(x);
                    }

                } else if (commands[commandIdx].equals("A")) {
                    int y = Integer.parseInt(commands[++commandIdx]);
                    for (int i = 0; i < y; i++) {
                        String cipher = commands[++commandIdx];
                        list.append(cipher);
                    }
                }
                ++commandIdx;
            }
            sb.append('#').append(testCase).append(' ');
            list.printFront10(sb);
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    static class DoublyLinkedList {
        static class Node {
            public String cipher;
            public Node previous;
            public Node next;

            public Node(String cipher) {
                this.cipher = cipher;
            }
        }

        private Node head;
        private Node tail;
        private Node cursor;
        public int currentIndex;

        public DoublyLinkedList() {
            head = new Node(null);
            tail = new Node(null);
            head.next = tail;
            tail.previous = head;
            cursor = head;
            currentIndex = 0;
        }

        public void append(String cipher) {
            Node newNode = new Node(cipher);
            tail.previous.next = newNode;
            newNode.previous = tail.previous;
            newNode.next = tail;
            tail.previous = newNode;
        }

        public void insert(int x, String cipher) {
            moveCursor(x);
            Node newNode = new Node(cipher);
            newNode.next = cursor.next;
            newNode.previous = cursor;
            cursor.next.previous = newNode;
            cursor.next = newNode;
        }

        public void remove(int x) {
            moveCursor(x);
            Node removed = cursor.next;
            removed.next.previous = cursor;
            cursor.next = removed.next;
        }

        public void moveCursor(int x) {
            while (currentIndex > x) {
                cursor = cursor.previous;
                --currentIndex;
            }
            while (currentIndex < x) {
                cursor = cursor.next;
                ++currentIndex;
            }
        }

        public void printFront10(StringBuilder sb) {
            Node current = head.next;
            for (int i = 0; i < 10; i++) {
                sb.append(current.cipher).append(' ');
                current = current.next;
            }
            sb.append('\n');
        }

        public void debug(StringBuilder sb) {
            Node current = head.next;
            while (current.cipher != null) {
                sb.append(current.cipher).append(' ');
                current = current.next;
            }
            sb.append('\n');
        }
    }
}