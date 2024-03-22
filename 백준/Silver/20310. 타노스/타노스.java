import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int cntZero = 0;
        int cntOne = 0;

        for (char c : arr) {
            if (c == '0') cntZero++;
        }

        cntOne = (arr.length - cntZero) / 2;
        cntZero /= 2;

        for (int i = 0; i < arr.length; i++) {
            if (cntOne == 0) break;
            if (arr[i] == '1') {
                cntOne--;
                arr[i] = ' ';
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (cntZero == 0) break;
            if (arr[i] == '0') {
                cntZero--;
                arr[i] = ' ';
            }
        }

        System.out.println(new String(arr).replaceAll(" ", ""));
    }
}