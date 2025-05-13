import java.util.*;
import java.io.*;

public class Main {
    static class Meeting {
        int start, end, people;
        Meeting(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.people = p;
        }
    }

    static int N;
    static Meeting[] meetings;
    static int maxPeople = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(s, e, p);
        }

        dfs(0, new ArrayList<>());
        System.out.println(maxPeople);
    }

    static void dfs(int idx, List<Meeting> selected) {
        if (idx == N) {
            if (isValid(selected)) {
                int sum = 0;
                for (Meeting m : selected) sum += m.people;
                maxPeople = Math.max(maxPeople, sum);
            }
            return;
        }

        dfs(idx + 1, selected);

        selected.add(meetings[idx]);
        dfs(idx + 1, selected);
        selected.remove(selected.size() - 1);
    }

    static boolean isValid(List<Meeting> selected) {
        for (int i = 0; i < selected.size(); i++) {
            for (int j = i + 1; j < selected.size(); j++) {
                Meeting a = selected.get(i);
                Meeting b = selected.get(j);
                if (a.start < b.end && b.start < a.end) return false;
            }
        }
        return true;
    }
}
