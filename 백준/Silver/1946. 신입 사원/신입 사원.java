import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            Applicant[] applicants = new Applicant[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                applicants[i] = new Applicant(document, interview);
            }
            Arrays.sort(applicants, (a1, a2) -> Integer.compare(a1.document, a2.document));
            int count = 1;
            int highestInterview = applicants[0].interview;
            for (int i = 1; i < n; i++) {
                if (applicants[i].interview < highestInterview) {
                    ++count;
                }
                highestInterview = Integer.min(highestInterview, applicants[i].interview);
            }
            System.out.println(count);
        }
    }

    private static class Applicant {
        public int document;
        public int interview;

        public Applicant(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
    }
}