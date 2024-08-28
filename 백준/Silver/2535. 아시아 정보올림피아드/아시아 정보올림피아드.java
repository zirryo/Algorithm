import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student {
    int country;
    int id;
    int score;

    public Student(int country, int id, int score) {
        this.country = country;
        this.id = id;
        this.score = score;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            students.add(new Student(country, id, score));
        }

        students.sort((a, b) -> b.score - a.score);

        Map<Integer, Integer> countryCount = new HashMap<>();
        int selected = 0;

        for (Student student : students) {
            int count = countryCount.getOrDefault(student.country, 0);
            if (count < 2) {
                System.out.println(student.country + " " + student.id);
                countryCount.put(student.country, count + 1);
                selected++;
            }
            // 상위 3명 선발되면 종료
            if (selected == 3) break;
        }
    }
}

