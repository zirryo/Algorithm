import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int y2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int ans1 = calcDay(y1, m1, d1);
        int ans2 = calcDay(y2, m2, d2);

        if(y2 - y1 > 1000 || y2 - y1 == 1000 && (m1 < m2 || m1 == m2 && d1 <= d2)) {
            System.out.println("gg");
        } else {
            System.out.println("D-" + (ans2 - ans1));
        }
    }
    private static int calcDay(int y, int m, int d){
        int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int days = 0;

        for(int i = 1; i < y; i++){
            days += 365 + checkYear(i);
        }

        for(int i = 1; i < m; i++){
            if(i == 2) days += checkYear(y);
            days += day[i];
        }

        days += d;

        return days;
    }

    private static int checkYear(int y){
        if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) return 1;
        else return 0;
    }
}