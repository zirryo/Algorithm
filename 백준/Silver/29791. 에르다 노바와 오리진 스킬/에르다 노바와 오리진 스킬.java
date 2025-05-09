import java.io.*;
import java.util.*;

public class Main {
    static final int ERDA_COOLDOWN = 100;
    static final int ORIGIN_COOLDOWN = 360;
    static final int IMMUNE_TIME = 90;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] erda = new int[n];
        int[] origin = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) erda[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) origin[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(erda);
        Arrays.sort(origin);

        int erdaCount = countSkillUse(erda, ERDA_COOLDOWN);
        int originCount = countSkillUse(origin, ORIGIN_COOLDOWN);

        System.out.println(erdaCount + " " + originCount);
    }

    private static int countSkillUse(int[] times, int cooldown) {
        int count = 0;
        int lastUsedTime = -cooldown;
        int lastImmuneEndTime = -IMMUNE_TIME;

        for (int t : times) {
            if (t - lastUsedTime >= cooldown && t - lastImmuneEndTime >= IMMUNE_TIME) {
                count++;
                lastUsedTime = t;
                lastImmuneEndTime = t;
            }
        }
        return count;
    }

}
