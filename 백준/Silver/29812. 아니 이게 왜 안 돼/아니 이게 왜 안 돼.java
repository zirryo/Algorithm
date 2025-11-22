import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        String[] in = br.readLine().split(" ");
        int D = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);

        long cost = 0;
        int bad = 0; // 삭제해야 할 연속 문자 
        int H = 0, Y = 0, U = 0;

        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            boolean keep = (c == 'H' || c == 'Y' || c == 'U');

            if (!keep) {
                bad++;
            } else {
                if (bad > 0) {
                    cost += Math.min((long)bad * D, (long)M + D);
                    bad = 0;
                }
                if (c == 'H') H++;
                else if (c == 'Y') Y++;
                else U++;
            }
        }

        if (bad > 0) cost += Math.min((long)bad * D, (long)M + D);

        if (cost == 0) System.out.println("Nalmeok");
        else System.out.println(cost);

        int hyu = Math.min(H, Math.min(Y, U));
        if (hyu == 0) System.out.println("I love HanYang University");
        else System.out.println(hyu);
    }
}
