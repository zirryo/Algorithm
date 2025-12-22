import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) break;

            long G = Long.parseLong(st.nextToken());
            long T = Long.parseLong(st.nextToken());
            long A = Long.parseLong(st.nextToken());
            long D = Long.parseLong(st.nextToken());
            
            if (G == -1 && T == -1 && A == -1 && D == -1) {
                break;
            }
            
            long groupMatches = G * (T * (T - 1) / 2);
            long actualTeams = (G * A) + D; 
            
            long powerOf2 = 1;
            while (powerOf2 < actualTeams) {
                powerOf2 *= 2;
            }
            
            long Y = powerOf2 - actualTeams;
            long tournamentMatches = powerOf2 - 1;
            long X = groupMatches + tournamentMatches;

            sb.append(G).append("*").append(A).append("/")
                    .append(T).append("+").append(D).append("=")
                    .append(X).append("+").append(Y).append("\n");
        }
        System.out.print(sb);
    }
}