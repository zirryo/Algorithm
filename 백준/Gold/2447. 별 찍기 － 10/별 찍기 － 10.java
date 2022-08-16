import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        star(0,0,N,false);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    static void star(int x, int y, int N, boolean blank) {
        if(blank) {
            for(int i=x; i<x+N; i++) {
                for(int j=y; j<y+N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        if(N==1) {
            arr[x][y] = '*';
            return;
        }

        int block = N/3;
        int cnt = 0;
        for(int i=x; i<x+N; i+=block) {
            for(int j=y; j<y+N; j+=block) {
                cnt++;
                if(cnt==5) star(i, j, block, true); // 공백
                else star(i, j, block, false);
            }
        }
    }
}