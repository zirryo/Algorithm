import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] arr = br.readLine().toCharArray();

            if (nextPermutation(arr)) {
                sb.append(new String(arr));
            } else {
                sb.append("BIGGEST");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static boolean nextPermutation(char[] arr) {
        int n = arr.length;

        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) return false;

        int j = n - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        swap(arr, i, j);

        reverse(arr, i + 1, n - 1);

        return true;
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}
