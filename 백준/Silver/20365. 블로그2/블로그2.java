import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String blog = br.readLine();

        int blueGroup = 0;
        int redGroup = 0;

        char currentColor = blog.charAt(0);
        if (currentColor == 'B') {
            blueGroup++;
        } else {
            redGroup++;
        }

        for (int i = 1; i < N; i++) {
            if (blog.charAt(i) != currentColor) {
                currentColor = blog.charAt(i);
                if (currentColor == 'B') {
                    blueGroup++;
                } else {
                    redGroup++;
                }
            }
        }

        int result = Math.min(blueGroup, redGroup) + 1;
        System.out.println(result);
    }
}