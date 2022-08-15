// 이항계수(조합) + 동적프로그래밍 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] memory = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(x-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            sb.append(nCr(n,r) + "\n");
        }
        System.out.println(sb);


    }
    static int nCr(int n, int r) {
        if(memory[n][r]>0) return memory[n][r];
        else if(n==r || r==0) return memory[n][r] = 1;
        return memory[n][r] = nCr(n-1,r-1) + nCr(n-1, r);
    }
}