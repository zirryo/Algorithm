import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[6];
        for(int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                arr[i*2 + j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(ccw(arr));

    }
    static int ccw(int[] arr) {
        int a = arr[0]*arr[3] + arr[2]*arr[5] + arr[4]*arr[1];
        int b = arr[2]*arr[1] + arr[4]*arr[3] + arr[0]*arr[5];

        if(a-b > 0) return 1;
        else if (a == b) return 0;
        else return -1;
    }

}