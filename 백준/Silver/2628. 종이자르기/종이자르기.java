import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();

        int n = sc.nextInt();

        List<Integer> hori = new ArrayList<>();
        List<Integer> vert = new ArrayList<>();

        hori.add(0);
        vert.add(0);
        hori.add(h);
        vert.add(w);

        for (int i = 0; i < n; i++) {
            int direction = sc.nextInt();
            int position = sc.nextInt();

            if (direction == 0) {
                hori.add(position);
            } else {
                vert.add(position);
            }
        }

        Collections.sort(hori);
        Collections.sort(vert);

        int maxHeight = 0;
        for (int i = 1; i < hori.size(); i++) {
            maxHeight = Math.max(maxHeight, hori.get(i) - hori.get(i - 1));
        }

        int maxWidth = 0;
        for (int i = 1; i < vert.size(); i++) {
            maxWidth = Math.max(maxWidth, vert.get(i) - vert.get(i - 1));
        }

        System.out.println(maxWidth * maxHeight);
    }
}
