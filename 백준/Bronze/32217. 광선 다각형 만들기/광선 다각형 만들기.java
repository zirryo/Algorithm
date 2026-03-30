import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalAngle = (N - 1) * 180;
        totalAngle /= 2;

        for (int i = 0; i < N; i++) {
            totalAngle -= Integer.parseInt(st.nextToken());
        }

        totalAngle *= 2;
        System.out.println(totalAngle);
    }
}