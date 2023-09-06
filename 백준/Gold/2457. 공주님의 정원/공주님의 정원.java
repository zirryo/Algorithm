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
        ArrayList<Flower> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            list.add(new Flower(sm, sd, em, ed));
        }
        Collections.sort(list);

        int idx = 0;
        int cnt = 0;
        int END = 301;

        while (END < 1201) {
            boolean addFlower = false;
            int tempEmd = -1;
            for (int i = idx; i < N; i++) {
                Flower cur = list.get(i);
                if (cur.start > END) break; // 공백 발생
                if (cur.end > tempEmd) {
                    addFlower = true;
                    tempEmd = cur.end;
                    idx = i + 1;
                }
            }

            if (addFlower) {
                END = tempEmd;
                cnt++;
            } else break;
        }

        if (END >= 1201) System.out.println(cnt);
        else System.out.println(0);

    }
}
class Flower implements Comparable<Flower> {
    int start;
    int end;

    public Flower(int startM, int startD, int endM, int endD) {
        this.start = startM * 100 + startD;
        this.end = endM * 100 + endD;
    }

    @Override
    public int compareTo(Flower f) {
        if (f.start == this.start) return f.end - this.end;
        return this.start - f.start;
    }
}