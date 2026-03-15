import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        int startDay = Integer.parseInt(br.readLine());

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if ((N % 4 == 0 && N % 100 != 0) || (N % 400 == 0)) {
            daysInMonth[1] = 29;
        }

        int totalVerticalCalendars = 0;
        for (int days : daysInMonth) {

            totalVerticalCalendars += (days - 28);
        }

        System.out.println(totalVerticalCalendars);
    }
}