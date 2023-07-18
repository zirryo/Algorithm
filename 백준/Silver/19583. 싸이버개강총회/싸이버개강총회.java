import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static String S, E, Q;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> attendance = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        E = st.nextToken();
        Q = st.nextToken();
        String input = "";
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            String timeStamp = st.nextToken();
            String nickname = st.nextToken();

            if (S.compareTo(timeStamp) >= 0) {
                attendance.add(nickname);
            } else if (E.compareTo(timeStamp) <= 0 && Q.compareTo(timeStamp) >= 0) {
                if (attendance.contains(nickname)) {
                    result++;
                    attendance.remove(nickname);
                }
            }
        }
        System.out.println(result);
    }
}