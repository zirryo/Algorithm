import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, len, zero, stage = 1;
    static int durability[];
    static boolean exist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        len = 2*N - 1;
        durability = new int[2*N];
        exist = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            // 1-1 벨트 회전
            int temp = durability[len];
            for(int i=len; i>0; i--) {
                durability[i] = durability[i-1];
            }
            durability[0] = temp;
            // 1-2 벨트 이동으로 인한 로봇 이동
            for(int i=N-1; i>0; i--) {
                exist[i] = exist[i-1];
            }
            exist[0] = false;
            // 2 - 로봇 이동
            exist[N-1] = false; // 내리는 위치
            for(int i=N-1; i>1; i--) {
                if(!exist[i-1]) continue;
                if(!exist[i] && durability[i] >= 1) {
                    exist[i] = true;
                    exist[i-1] = false;
                    durability[i]--;
                    if(durability[i] == 0) zero++;
                }
            }
            // 3 - 로봇 올리기
            if(durability[0] > 0) {
                exist[0] = true;
                durability[0]--;
                if(durability[0] == 0) zero++;
            }

            if(zero >= K) break;
            stage++;
        }
        System.out.println(stage);
    }
}