import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String[] student = br.readLine().split(" ");
            String name = student[0];
            int day = Integer.parseInt(student[1]);
            int month = Integer.parseInt(student[2]);
            int year = Integer.parseInt(student[3]);
            LocalDate birthday = LocalDate.of(year, month, day);
            students[i] = new Student(name, birthday);
        }

        Arrays.sort(students);
        StringBuilder sb = new StringBuilder();
        sb.append(students[n - 1].name).append('\n').append(students[0].name);

        System.out.println(sb.toString());
        br.close();
    }

    static class Student implements Comparable<Student> {

        public String name;
        public LocalDate birthday;

        public Student(String name, LocalDate birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        @Override
        public int compareTo(Student other) {
            return this.birthday.compareTo(other.birthday);
        }
    }
}