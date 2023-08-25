import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Task> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list.add(new Task(t, s));
        }

        Collections.sort(list);
        int now = list.get(0).s;

        for (Task cur : list) {
            if (now > cur.s) now = cur.s;
            now -= cur.t;

            if (now < 0) break;
        }

        if (now < 0) System.out.println(-1);
        else System.out.println(now);
    }
}
class Task implements Comparable<Task> {
    int t;
    int s;

    public Task(int t, int s) {
        this.t = t;
        this.s = s;
    }

    @Override
    public int compareTo(Task task) {
        if (task.s == this.s) return task.t - this.t;
        return task.s - this.s;
    }
}