import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] scores = {
                3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1
        };

        String name1 = br.readLine();
        String name2 = br.readLine();
        int length = name1.length();

        int[] arr = new int[length * 2];

        for (int i = 0; i < length; i++) {
            arr[i * 2] = scores[name1.charAt(i) - 'A'];
            arr[i * 2 + 1] = scores[name2.charAt(i) - 'A'];
        }

        while (arr.length > 2) {
            int[] newArr = new int[arr.length - 1];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = (arr[i] + arr[i + 1]) % 10;
            }
            arr = newArr;
        }

        System.out.println("" + arr[0] + arr[1]);
    }
}
