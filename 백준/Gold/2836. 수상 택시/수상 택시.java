import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Vector> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a < b) continue;
            list.add(new Vector(b, a));
        }

        Collections.sort(list);
        long result = 0L;
        int left = list.get(0).s;
        int right = list.get(0).e;

        for (int i = 1; i < list.size(); i++) {
            if (right < list.get(i).s) { // 새로운 선분이 시작되는 경우
                result += (right - left) * 2;
                left = list.get(i).s;
                right = list.get(i).e;
            } else if (right >= list.get(i).s) { // 기존 선분이 이어지는 경우
                right = Math.max(right, list.get(i).e);
            }
        }
        result += (right - left) * 2;
        result += M;
        System.out.println(result);
    }
    private static class Vector implements Comparable<Vector> {
        int s;
        int e;

        public Vector(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Vector v) {
            if(this.s == v.s) return this.e - v.e;
            return this.s - v.s;
        }
    }
}