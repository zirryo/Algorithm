import java.io.*;
import java.util.*;

public class Main {
    static class Condo {
        int distance;
        int cost;

        Condo(int distance, int cost) {
            this.distance = distance;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Condo[] condos = new Condo[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            condos[i] = new Condo(d, c);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            Condo current = condos[i];
            boolean isCandidate = true;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                Condo other = condos[j];

                if (other.distance < current.distance && other.cost <= current.cost) {
                    isCandidate = false;
                    break;
                }

                if (other.cost < current.cost && other.distance <= current.distance) {
                    isCandidate = false;
                    break;
                }
            }

            if (isCandidate) count++;
        }

        System.out.println(count);
    }
}
