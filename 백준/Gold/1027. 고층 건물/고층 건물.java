import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] height;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        height = new int[N];
        count = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) height[i] = Integer.parseInt(st.nextToken());

        isVisible();
        Arrays.sort(count);
        System.out.println(count[N-1]);
    }
    static void isVisible() {
        for(int i=0; i<N-1; i++) {
            count[i]++;
            count[i+1]++;
            double slope = height[i+1] - height[i];
            for(int j=i+2; j<N; j++) {
                double nextSlope = (double)(height[i]-height[j])/(i-j);
                if(slope>=nextSlope) continue;
                slope = nextSlope;
                count[i]++;
                count[j]++;
            }
        }
    }
}