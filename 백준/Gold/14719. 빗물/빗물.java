import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, W;
    static int[] block;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        block = new int[W];
        for(int i = 0; i < W; i++) block[i] = Integer.parseInt(st.nextToken());
        System.out.println(getRainWater());
    }
    private static int getRainWater() {
        if(W <= 2) return 0;
        int result = 0;
        for(int i = 1; i < W-1; i++) {
            int lMax = 0, rMax = 0;
            for(int j = 0; j < i; j++) {
                lMax = Math.max(lMax, block[j]);
            }
            for(int j = i+1; j < W; j++) {
                rMax = Math.max(rMax, block[j]);
                if(lMax <= rMax) break;
            }
            int rainWater = Math.min(lMax, rMax) - block[i];
            if(rainWater > 0) result += rainWater;
        }
        return result;
    }
}