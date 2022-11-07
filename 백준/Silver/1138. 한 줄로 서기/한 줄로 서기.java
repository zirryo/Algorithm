import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            int idx = arr[i];
            for(int cnt=0; cnt<=idx; cnt++) {
                if(result[cnt] != 0 && result[cnt] < i+1) {
                    idx++; // for 문의 길이 증가 
                }
            }
            result[idx] = i+1;
        }

        for(int i : result) sb.append(i).append(" ");
        System.out.println(sb);
    }
}