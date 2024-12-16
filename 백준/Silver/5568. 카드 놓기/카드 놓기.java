import java.util.*;

public class Main {
    static Set<String> uniqueNumbers = new HashSet<>(); // 중복 제거를 위한 Set
    static int[] cards;
    static boolean[] visited;
    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        n = Integer.parseInt(sc.nextLine());
        k = Integer.parseInt(sc.nextLine());

        cards = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(sc.nextLine());
        }

        generateNumbers("", 0);

        System.out.println(uniqueNumbers.size());
    }

    private static void generateNumbers(String current, int depth) {
        if (depth == k) {
            uniqueNumbers.add(current);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                generateNumbers(current + cards[i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
