import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] matrix = new String[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().split(" ");
        }

        Arrays.sort(matrix, Comparator.comparing(o -> o[1]));

        System.out.println(matrix[0][0]);
    }
}