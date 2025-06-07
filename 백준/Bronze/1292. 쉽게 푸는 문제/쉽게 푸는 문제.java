import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; list.size() < B; i++) {
            for (int j = 0; j < i; j++) {
                list.add(i);
            }
        }

        int sum = 0;
        for (int i = A - 1; i < B; i++) {
            sum += list.get(i);
        }

        System.out.println(sum);
    }
}
