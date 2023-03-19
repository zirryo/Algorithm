import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        for(int i=0; i<4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
                result.append("d").append("\n");
            }
            else if (x1==p2 || p1==x2) {
                if(q1==y2 || q2==y1) result.append("c").append("\n");
                else result.append("b").append("\n");
            }
            else if (q1==y2 || q2==y1) {
                result.append("b").append("\n");
            }
            else result.append("a").append("\n");
        }
        System.out.println(result);
    }
}