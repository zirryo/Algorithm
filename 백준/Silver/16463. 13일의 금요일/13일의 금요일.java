import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int firstDay = 2;

        long count = 0;

        for (int year = 2019; year <= N; year++) {
            for (int month = 1; month <= 12; month++) {
                int w13 = (firstDay + 12) % 7;
                if (w13 == 5) count++;

                int dim;
                switch (month) {
                    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                        dim = 31; break;
                    case 4: case 6: case 9: case 11:
                        dim = 30; break;
                    case 2:
                        dim = isLeap(year) ? 29 : 28; break;
                    default:
                        dim = 30; break;
                }

                firstDay = (firstDay + dim) % 7;
            }
        }

        System.out.println(count);
    }

    static boolean isLeap(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return y % 4 == 0;
    }
}
