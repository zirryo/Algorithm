import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] choco = new int[5]; // H, T, C, K, G
        int total = 0;

        for (int i = 0; i < 5; i++) {
            choco[i] = Integer.parseInt(st.nextToken());
            total += choco[i];
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int curEat = 0;
            for (int i = 0; i < 5; i++) {
                int eat = Integer.parseInt(st.nextToken());
                choco[i] -= eat;
                curEat += eat;
            }

            int num = total % 10;
            total -= curEat;
            if (num == 0 || num == 1) {
                sb.append(total).append("7H\n");
            } else {
                sb.append(Integer.toString(total, num)).append("7H\n");
            }
            if (total == 0) sb.append("NULL\n");
            else sb.append(makeChocoList(choco)).append("\n");
        }

        System.out.println(sb);

    }
    private static String makeChocoList(int[] choco) {
        char[] type = new char[]{'H', 'T', 'C', 'K', 'G'};
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            map.put(type[i], choco[i]);
        }

        List<Character> list = new ArrayList<>(map.keySet());

        Collections.sort(list, ((o1, o2) -> {
            if (map.get(o1) == map.get(o2)) return o1 - o2;
            else return map.get(o2) - map.get(o1);
        }));

        String result = "";
        for (int i = 0; i < 5; i++) {
            if (map.get(list.get(i)) == 0) continue;
            else result += list.get(i);
        }

        return result;
    }
}