import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int dd = Integer.parseInt(st.nextToken());
            int mm = Integer.parseInt(st.nextToken());
            int yyyy = Integer.parseInt(st.nextToken());
            list.add(new Student(name, dd, mm, yyyy));
        }

        Collections.sort(list);
        System.out.printf(String.format("%s\n%s", list.get(N-1).name, list.get(0).name));
    }
}
class Student implements Comparable<Student> {
    String name;
    int day;
    int month;
    int year;

    public Student(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public int compareTo(Student student) {
        if (student.year == this.year) {
            if (student.month == this.month) {
                return this.day - student.day;
            } else {
                return this.month - student.month;
            }
        } else {
            return this.year - student.year;
        }
    }
}