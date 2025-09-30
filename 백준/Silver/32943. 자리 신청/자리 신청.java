import java.io.*;
import java.util.*;

public class Main {
    static class Log {
        int time, seatNum, studentNum;
        Log(int t, int s, int n) {
            this.time = t;
            this.seatNum = s;
            this.studentNum = n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Log> logs = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            logs.add(new Log(T, S, N));
        }

        logs.sort(Comparator.comparingInt(o -> o.time));

        Map<Integer, Integer> seatToStudent = new HashMap<>();
        Map<Integer, Integer> studentToSeat = new HashMap<>();

        for (Log log : logs) {
            int seat = log.seatNum;
            int student = log.studentNum;

            if (seatToStudent.containsKey(seat)) continue;

            if (studentToSeat.containsKey(student)) {
                int oldSeat = studentToSeat.get(student);
                seatToStudent.remove(oldSeat);
            }

            seatToStudent.put(seat, student);
            studentToSeat.put(student, seat);
        }

        List<Integer> students = new ArrayList<>(studentToSeat.keySet());
        Collections.sort(students);

        StringBuilder sb = new StringBuilder();
        for (int student : students) {
            sb.append(student).append(" ").append(studentToSeat.get(student)).append("\n");
        }

        System.out.print(sb);
    }
}
