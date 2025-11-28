import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Student[] students = new Student[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, korean, math, english);
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(students).sorted().forEach(s -> sb.append(s.name).append('\n'));

        System.out.println(sb.toString());
        br.close();
    }

    static class Student implements Comparable<Student> {
        public String name;
        public int korean;
        public int math;
        public int english;

        public Student(String name, int korean, int math, int english) {
            this.name = name;
            this.korean = korean;
            this.math = math;
            this.english = english;
        }


        @Override
        public int compareTo(Student other) {
            if (this.korean != other.korean) {
                return Integer.compare(other.korean, this.korean);
            }
            if (this.english != other.english) {
                return Integer.compare(this.english, other.english);
            }
            if (this.math != other.math) {
                return Integer.compare(other.math, this.math);
            }
            return this.name.compareTo(other.name);
        }
    }
}