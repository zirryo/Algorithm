import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static double[][] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        points = new double[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Double.parseDouble(st.nextToken());
            points[i][1] = Double.parseDouble(st.nextToken());
        }

        
        double result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    result = Math.max(result, getArea(i, j, k));
                }
            }
        }

        System.out.print(result);
    }

    // 세 점의 좌표를 활용한 삼각형 넓이 공식
    static double getArea(int i, int j, int k) {
        double area = (points[i][0] * points[j][1] + points[j][0] * points[k][1] + points[k][0] * points[i][1])
                - (points[j][0] * points[i][1] + points[k][0] * points[j][1] + points[i][0] * points[k][1]);
        return Math.abs(area) / 2.0;
    }
}