import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int W;
    public static int H;
    public static int X;
    public static int Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while(P-->0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            if(inArea(x1, y1)) cnt++;
        }
        System.out.println(cnt);
    }
    public static boolean inArea(int x1, int y1) {
        // (1) 좌측 원 내부
        if(Math.pow(x1-X, 2) + Math.pow(y1-Y-H/2, 2) <= Math.pow(H/2, 2)) return true;
        // (2) 우측 원 내부
        else if(Math.pow(x1-X-W, 2) + Math.pow(y1-Y-H/2, 2) <= Math.pow(H/2, 2)) return true;
        // (3) 중앙 사각형 내부
        else if(X <= x1 && x1 <= X+W && Y <= y1 && y1 <= Y+H) return true;

        return false;
    }
}