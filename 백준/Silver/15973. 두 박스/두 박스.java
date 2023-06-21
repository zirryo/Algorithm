import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int p1 = Integer.parseInt(st.nextToken());
        int q1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int q2 = Integer.parseInt(st.nextToken());

            if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
                result.append("NULL").append("\n");
            }
            else if (x1==p2 || p1==x2) {
                if(q1==y2 || q2==y1) result.append("POINT").append("\n");
                else result.append("LINE").append("\n");
            }
            else if (q1==y2 || q2==y1) {
                result.append("LINE").append("\n");
            }
            else result.append("FACE").append("\n");

        System.out.println(result);
    }
}