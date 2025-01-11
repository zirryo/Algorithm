import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 1; 
        int incLength = 1; 
        int decLength = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                incLength++; 
            } else {
                incLength = 1; 
            }

            if (arr[i] <= arr[i - 1]) {
                decLength++; 
            } else {
                decLength = 1; 
            }

            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }

        System.out.println(maxLength);
    }
}
