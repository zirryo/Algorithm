import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        countPeople(); // 아파트 각 호수의 모든 거주민 수를 담은 array 생성

        while(x-->0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[k][n] + "\n");
        }
        System.out.println(sb);
    }

    public static void countPeople() {

        for(int i=0; i<15; i++) {
            arr[0][i] = i;
            arr[i][1] = 1;
        }
        for(int i=1; i<15; i++) { // i는 층, 1층부터 14층까지를 나타냄.
            for(int j=2; j<15; j++) { // j는 호, 1호는 1명이므로, 2호부터 지정함.
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }
    }
}