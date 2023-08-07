import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] votes = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        ArrayList<Candidate> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (set.contains(x)) {
                votes[x]++;
                continue;
            } else if (set.size() >= N) {
                Collections.sort(list);
                Candidate exit = list.remove(0);
                set.remove(exit.num);
                votes[exit.num] = 0;
            }
            list.add(new Candidate(i, x));
            set.add(x);
            votes[x]++;
        }

        List<Integer> answer = new ArrayList<>();
        for (Candidate candidate : list) {
            answer.add(candidate.num);
        }

        Collections.sort(answer);
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    static class Candidate implements Comparable<Candidate> {
        int time;
        int num;

        public Candidate(int time, int num) {
            this.time = time;
            this.num = num;
        }

        @Override
        public int compareTo(Candidate c) {
            if (votes[c.num] == votes[this.num]) return this.time - c.time;
            return votes[this.num] - votes[c.num];
        }
    }
}
