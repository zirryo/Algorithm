import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 동굴의 길이
        int H = Integer.parseInt(st.nextToken()); // 동굴의 높이
        int min = Integer.MAX_VALUE;
        int destroy = 0;
        int cnt = 0;
        int[] stalagmite = new int[H+1]; // 석순
        int[] stalactite = new int[H+1]; // 종유석

        for(int i=0; i<N/2; i++) {
            stalagmite[Integer.parseInt(br.readLine())]++;
            stalactite[Integer.parseInt(br.readLine())]++;
        }

         // 카운팅 정렬 배열을 역순으로 누적합
        for(int i=H-1; i>=1; i--) {
            stalagmite[i] += stalagmite[i+1];
            stalactite[i] += stalactite[i+1];
        }

        for(int i=1; i<=H; i++) {
            destroy = stalagmite[i] + stalactite[H-i+1];
            if(destroy<min) {
                min = destroy;
                cnt = 1;
            } else if (destroy==min) {
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);
    }
}