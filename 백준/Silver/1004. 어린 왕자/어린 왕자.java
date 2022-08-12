import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int circle = Integer.parseInt(br.readLine());
            int count = 0;
            for(int j=0; j<circle; j++) {
                st = new StringTokenizer(br.readLine());
                int x0 = Integer.parseInt(st.nextToken());
                int y0 = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean a = contain(x1, y1, x0, y0, r);
                boolean b = contain(x2, y2, x0, y0, r);

                if(!a && b || a && !b) count++;
            }
            System.out.println(count);
        }

    }

    // 좌표와 원의 중심 사이의 거리가 원의 반지름 보다 작으면 해당 좌표는 원의 내부에 있다.(true)
    static boolean contain (int x1, int y1, int x0, int y0, int r) {
        return Math.pow(x0-x1, 2) + Math.pow(y0-y1, 2) < Math.pow(r, 2);
    }
}