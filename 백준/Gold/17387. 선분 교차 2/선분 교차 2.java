import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        int val1 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
        int val2 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);
        if (val1 == 0 && val2 == 0) { // 세점이 일직선 상에 놓인 경우
            if(intersection(x1, y1, x2, y2, x3, y3, x4, y4)) { // 두 선분이 같은 직선 상에 존재하고 교차하는 경우
                System.out.println("1");
            } else System.out.println("0"); // 두 선분이 같은 직선 상에 존재하나 교차하지 않는 경우
        }
        else if (val1 <= 0 && val2 <= 0) System.out.println("1");
        else System.out.println("0");
        br.close();
    }

    public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long cal = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3);

        if(cal == 0) return 0;
        else if(cal > 0) return 1;
        else return -1;
    }
    private static boolean intersection(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // 선분1의 두 좌표 중 작은 값이 선분2의 두 좌표 중 큰 값보다 작아야하고,
        // 선분2의 두 좌표 중 작은 값이 선분1의 두 좌표 중 큰 값보다 작아야 함.
        return !(Math.min(x1, x2) > Math.max(x3, x4) || Math.min(x3, x4) > Math.max(x1, x2)
                || Math.min(y1, y2) > Math.max(y3, y4) || Math.min(y3, y4) > Math.max(y1, y2));
    }
}