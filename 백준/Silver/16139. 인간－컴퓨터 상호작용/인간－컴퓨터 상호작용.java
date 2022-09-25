import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] arr = new int[str.length()][26];

        arr[0][str.charAt(0)-'a'] = 1;

        for(int i=1; i< str.length(); i++) {
            int temp = str.charAt(i) -'a';
            for(int j=0; j<26; j++) {
                arr[i][j] = arr[i-1][j]; // 누적합 갱신 X
            }
            arr[i][temp]++; // 누적합 갱신
        }

        while(q-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start==0) sb.append(arr[end][c - 'a']).append("\n");
            else sb.append(arr[end][c - 'a'] - arr[start-1][c - 'a']).append("\n");
        }
        System.out.println(sb);
    }
}