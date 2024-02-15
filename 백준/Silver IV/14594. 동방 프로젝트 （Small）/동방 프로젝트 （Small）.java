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
        int M = Integer.parseInt(br.readLine());
        ArrayList<Villain> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Villain(x, y));
        }
        Collections.sort(list);
        int roomNum = 1;
        int result = 0;

        for (Villain cur : list) {
            if (roomNum < cur.s) {
                result += cur.s - roomNum;
            }
            if (cur.e > roomNum) roomNum = cur.e;
        }

        result += N - roomNum + 1;

        System.out.println(result);
    }
    private static class Villain implements Comparable<Villain> {
        int s;
        int e;

        public Villain(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Villain v) {
            if (this.s == v.s) return this.e - v.e;
            return this.s - v.s;
        }
    }
}