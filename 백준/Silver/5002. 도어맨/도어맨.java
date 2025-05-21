import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();

        List<Character> queue = new ArrayList<>();
        for (char c : line.toCharArray()) {
            queue.add(c);
        }

        int men = 0;
        int women = 0;
        int count = 0;

        for (int i = 0; i < queue.size();) {
            char person = queue.get(i);
            int nextMen = men + (person == 'M' ? 1 : 0);
            int nextWomen = women + (person == 'W' ? 1 : 0);

            if (Math.abs(nextMen - nextWomen) <= X) {
                if (person == 'M') men++;
                else women++;
                count++;
                i++;
            } else {
                // 현재 사람 입장 불가, 다음 사람과 바꿀 수 있는지 확인
                if (i + 1 >= queue.size()) break;

                char nextPerson = queue.get(i + 1);
                int altMen = men + (nextPerson == 'M' ? 1 : 0);
                int altWomen = women + (nextPerson == 'W' ? 1 : 0);

                if (Math.abs(altMen - altWomen) <= X) {
                    if (nextPerson == 'M') men++;
                    else women++;
                    count++;
                    queue.remove(i + 1);
                } else {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
