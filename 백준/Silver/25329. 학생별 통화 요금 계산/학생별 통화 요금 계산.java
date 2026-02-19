import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> studentTimes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String timeStr = st.nextToken();
            String name = st.nextToken();

            String[] parts = timeStr.split(":");
            int minutes = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);

            studentTimes.put(name, studentTimes.getOrDefault(name, 0) + minutes);
        }

        List<Student> result = new ArrayList<>();
        for (String name : studentTimes.keySet()) {
            int totalTime = studentTimes.get(name);
            long fee = calculateFee(totalTime);
            result.add(new Student(name, fee));
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for (Student s : result) {
            sb.append(s.name).append(" ").append(s.fee).append("\n");
        }
        System.out.print(sb);
    }

    private static int calculateFee(int time) {
        if (time <= 100) return 10;

        int extraTime = time - 100;
        int units = (extraTime + 49) / 50;
        return 10 + units * 3;
    }

    static class Student implements Comparable<Student> {
        String name;
        long fee;

        Student(String name, long fee) {
            this.name = name;
            this.fee = fee;
        }

        @Override
        public int compareTo(Student o) {
            if (this.fee != o.fee) {
                return Long.compare(o.fee, this.fee);
            }

            return this.name.compareTo(o.name);
        }
    }
}