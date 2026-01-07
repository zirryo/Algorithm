import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        long v1 = A * x1 + B * y1 + C;
        long v2 = A * x1 + B * y2 + C;
        long v3 = A * x2 + B * y1 + C;
        long v4 = A * x2 + B * y2 + C;

        if ((v1 >= 0 && v2 >= 0 && v3 >= 0 && v4 >= 0) ||
                (v1 <= 0 && v2 <= 0 && v3 <= 0 && v4 <= 0)) {
            System.out.println("Lucky");
        } else {
            boolean through = false; // 직사각형 내부 통과 판별

            if (A == 0) { // 직선이 x축과 평행한 경우
                double targetY = (double) -C / B;
                if (targetY > y1 && targetY < y2) through = true;
            }

            else if (B == 0) { // 직선이 y축과 평행한 경우
                double targetX = (double) -C / A;
                if (targetX > x1 && targetX < x2) through = true;
            }

            else through = true;

            System.out.println(through ? "Poor" : "Lucky");
        }
    }
}