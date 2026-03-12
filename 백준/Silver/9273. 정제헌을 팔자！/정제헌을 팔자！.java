import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) break;
            int n = Integer.parseInt(line.split("/")[1]);

            long div = 1;
            int tempN = n;

            for (int i = 2; i * i <= tempN; i++) {
                if (tempN % i == 0) {
                    int count = 0;
                    while (tempN % i == 0) {
                        count++;
                        tempN /= i;
                    }
                    div *= (2L * count + 1);
                }
            }

            if (tempN > 1) {
                div *= 3;
            }

            sb.append((div + 1) / 2).append("\n");
        }
        System.out.println(sb);
    }
}