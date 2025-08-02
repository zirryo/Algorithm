import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int idx = 0;

        while (idx < N) {
            int timeLeft = 30;

            while (idx < N && timeLeft > 0) {
                if (T[idx] <= timeLeft) {

                    timeLeft -= T[idx];
                    count++;
                    idx++;
                } else {
                    int listened = timeLeft;
                    if (listened * 2 >= T[idx]) {
                        count++;
                    }
                    idx++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
