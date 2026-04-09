import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken()); // (
        long B = Long.parseLong(st.nextToken()); // ((
        long C = Long.parseLong(st.nextToken()); // )
        long D = Long.parseLong(st.nextToken()); // ))
        long E = Long.parseLong(st.nextToken()); // ()
        long F = Long.parseLong(st.nextToken()); // )(

        long result = E * 2;
        long openCnt = A + 2 * B;
        long closeCnt = C + 2 * D;
        long limit = Math.min(openCnt, closeCnt);

        if (limit % 2 == 1) {
            if (A == 0 || C == 0) limit--;
        }

        if (F > 0) {
            if (limit > 0) {
                result += (F * 2) + (limit * 2);
            }
        } else {
            result += (limit * 2);
        }

        System.out.println(result);
    }
}