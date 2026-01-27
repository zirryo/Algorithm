import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String ax = "";
        String b = "";

        if (s.contains("x")) {
            int xIdx = s.indexOf("x");
            ax = s.substring(0, xIdx); // x 앞부분 (계수)
            b = s.substring(xIdx + 1); // x 뒷부분 (상수항)
        } else {
            b = s; // x가 없으면 전체가 상수항
        }

        StringBuilder sb = new StringBuilder();

        // 일차항(ax) 적분
        if (ax.length() > 0 || s.contains("x")) {
            int a = 0;
            if (ax.equals("") || ax.equals("+")) a = 1;
            else if (ax.equals("-")) a = -1;
            else a = Integer.parseInt(ax);

            int newA = a / 2;
            if (newA == 1) sb.append("xx");
            else if (newA == -1) sb.append("-xx");
            else if (newA != 0) sb.append(newA).append("xx");
        }

        // 상수항(b) 적분
        if (b.length() > 0) {
            int valB = Integer.parseInt(b);
            if (valB != 0) {
                if (valB > 0 && sb.length() > 0) sb.append("+");

                if (valB == 1) sb.append("x");
                else if (valB == -1) sb.append("-x");
                else sb.append(valB).append("x");
            }
        }

        // 적분 상수
        if (sb.length() > 0 && !sb.toString().equals("-")) {
            sb.append("+W");
        } else {
            sb.append("W");
        }

        System.out.println(sb);
    }
}