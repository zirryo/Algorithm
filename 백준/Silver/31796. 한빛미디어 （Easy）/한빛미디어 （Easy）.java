import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] S = new int[N];
        for (int i = 0; i < N; i++) S[i] = sc.nextInt();

        Arrays.sort(S);

        int pages = 1;
        int minPrice = S[0];

        for (int i = 1; i < N; i++) {
            if (S[i] >= minPrice * 2) {
                pages++;
                minPrice = S[i];
            }
        }

        System.out.println(pages);
    }
}
