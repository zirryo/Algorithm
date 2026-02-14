import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        boolean[] checked = new boolean[4];
        boolean isPossible = true;

        if (N % 2 != 0) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);

            switch (c) {
                case 'P':
                    if (i % 2 != 0) {
                        isPossible = false;
                    } else {
                        checked[0] = true;
                    }
                    break;
                case 'A':
                    if (i % 2 == 0 || !checked[0]) {
                        isPossible = false;
                    } else {
                        checked[1] = true;
                    }
                    break;
                case 'U':
                    if (i % 2 != 0 || !checked[0] || !checked[1]) {
                        isPossible = false;
                    } else {
                        checked[2] = true;
                    }
                    break;
                case 'L':
                    if (i % 2 == 0 || !checked[0] || !checked[1] || !checked[2]) {
                        isPossible = false;
                    } else {
                        checked[3] = true;
                    }
                    break;
            }
        }

        if (checked[3] && isPossible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}