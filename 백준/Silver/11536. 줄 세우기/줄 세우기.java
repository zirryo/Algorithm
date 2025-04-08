import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            names.add(br.readLine());
        }

        List<String> sorted = new ArrayList<>(names);
        Collections.sort(sorted);

        List<String> reversed = new ArrayList<>(names);
        Collections.sort(reversed, Collections.reverseOrder());

        if (names.equals(sorted)) {
            System.out.println("INCREASING");
        } else if (names.equals(reversed)) {
            System.out.println("DECREASING");
        } else {
            System.out.println("NEITHER");
        }
    }
}
