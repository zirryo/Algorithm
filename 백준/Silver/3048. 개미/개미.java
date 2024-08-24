import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N1 = sc.nextInt();
        int N2 = sc.nextInt();
        String group1 = sc.next();
        String group2 = sc.next();
        int T = sc.nextInt();
        Map<Character, Character> map = new HashMap<>();
        for (char c : group1.toCharArray()) {
            map.put(c, 'R');
        }
        for (char c : group2.toCharArray()) {
            map.put(c, 'L');
        }

        StringBuilder sb = new StringBuilder();
        sb.append(new StringBuilder(group1).reverse());
        sb.append(group2);

        char[] ants = sb.toString().toCharArray();

        for (int t = 0; t < T; t++) {
            boolean[] swapped = new boolean[ants.length];  // 한 턴 동안 이미 바뀐 개미를 추적

            for (int i = 0; i < ants.length - 1; i++) {
                // 서로 교차하는 개미들 (첫 번째 그룹에서 온 개미는 왼쪽, 두 번째 그룹은 오른쪽)
                if (!swapped[i]) {
                    if (i == 0 && map.get(ants[i]) == 'L') continue;
                    if ((i+1) == ants.length - 1 && map.get(ants[i+1]) == 'R') continue;
                    if (map.get(ants[i]) == 'R' && map.get(ants[i+1]) == 'L') {
                        char temp = ants[i];
                        ants[i] = ants[i + 1];
                        ants[i + 1] = temp;
                        swapped[i + 1] = true;  // 바뀐 위치 표시
                    }
                }
            }
        }

        System.out.println(new String(ants));
    }
}
