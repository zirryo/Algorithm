import java.io.*;
import java.util.*;

public class Main {
    static class Problem implements Comparable<Problem> {
        String name;
        int id;
        int difficulty;

        Problem(String name, int id, int difficulty) {
            this.name = name;
            this.id = id;
            this.difficulty = difficulty;
        }

        @Override
        public int compareTo(Problem o) {
            return this.id - o.id;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Problem> problems = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            int I = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            problems.add(new Problem(S, I, D));
        }

        Collections.sort(problems);

        StringBuilder sb = new StringBuilder();
        for (Problem p : problems) {
            char targetChar = p.name.charAt(p.difficulty - 1);
            sb.append(Character.toUpperCase(targetChar));
        }

        System.out.println(sb);
    }
}