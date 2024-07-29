import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int korean;
    int english;
    int math;

    Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Student other) {
        if (this.korean != other.korean) {
            return other.korean - this.korean; // 국어 점수 내림차순
        } else if (this.english != other.english) {
            return this.english - other.english; // 영어 점수 오름차순
        } else if (this.math != other.math) {
            return other.math - this.math; // 수학 점수 내림차순
        } else {
            return this.name.compareTo(other.name); // 이름 사전순
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String name = scanner.next();
            int korean = scanner.nextInt();
            int english = scanner.nextInt();
            int math = scanner.nextInt();
            students.add(new Student(name, korean, english, math));
        }

        scanner.close();

        Collections.sort(students);
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.name).append("\n");
        }
        System.out.println(sb);
    }
}
