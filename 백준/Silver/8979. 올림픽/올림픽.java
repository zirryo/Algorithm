import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Nation> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Nation(n, g, s, b));
        }

        Collections.sort(list);

        int rank = 0;
        int same = 1;

        Nation prev = new Nation(1001, 1000000, 0, 0);
        Nation cur;

        for (int i=0; i<N; i++) {
            cur = list.get(i);

            if ((prev.gold != cur.gold) || (prev.silver != cur.silver) || (prev.bronze != cur.bronze)) {
                rank += same;
                same = 1;
            } else same++;

            if (cur.num == K) {
                System.out.println(rank);
                break;
            }

            prev = cur;
        }
    }
}
class Nation implements Comparable<Nation> {
    int num;
    int gold;
    int silver;
    int bronze;

    public Nation(int num, int gold, int silver, int bronze) {
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Nation n) {
        if (n.gold == this.gold) {
            if (n.silver == this.silver) {
                return n.bronze - this.bronze;
            } else {
                return n.silver - this.silver;
            }
        } else {
            return n.gold - this.gold;
        }
    }
}