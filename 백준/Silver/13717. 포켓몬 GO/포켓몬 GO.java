import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int totalEvolve = 0;
        int maxEvolve = -1;
        String maxPokemon = "";

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int count = 0;
            if (m >= k) {
                count = (m - k) / (k - 2) + 1;
            }

            totalEvolve += count;

            if (count > maxEvolve) {
                maxEvolve = count;
                maxPokemon = name;
            }
        }

        System.out.println(totalEvolve);
        System.out.println(maxPokemon);
    }
}
