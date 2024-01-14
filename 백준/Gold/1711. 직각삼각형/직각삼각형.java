import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result = 0;
    static int[] select;
    static Pos[] posArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        select = new int[3];
        posArr = new Pos[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            posArr[i] = new Pos(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }
        combination(0, 0);
        System.out.println(result);

    }
    private static void combination(int depth, int idx) {
        if (depth == 3) {
            makeTriangle();
            return;
        }

        for (int i = idx; i < N; i++) {
            select[depth] = i;
            combination(depth + 1, i + 1);
        }
    }
    private static void makeTriangle() {
        long len1 = (posArr[select[0]].x - posArr[select[1]].x) * (posArr[select[0]].x - posArr[select[1]].x)
                + (posArr[select[0]].y - posArr[select[1]].y) * (posArr[select[0]].y - posArr[select[1]].y);
        long len2 = (posArr[select[1]].x - posArr[select[2]].x) * (posArr[select[1]].x - posArr[select[2]].x)
                + (posArr[select[1]].y - posArr[select[2]].y) * (posArr[select[1]].y - posArr[select[2]].y);
        long len3 = (posArr[select[0]].x - posArr[select[2]].x) * (posArr[select[0]].x - posArr[select[2]].x)
                + (posArr[select[0]].y - posArr[select[2]].y) * (posArr[select[0]].y - posArr[select[2]].y);

        if (len1 == (len2 + len3) || len2 == (len1 + len3) || len3 == (len1 + len2)) {
            result++;
        }
    }
    private static class Pos {
        long x;
        long y;

        public Pos(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}