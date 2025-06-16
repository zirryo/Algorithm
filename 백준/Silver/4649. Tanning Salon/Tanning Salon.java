import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String input;

        while (true) {
            input = br.readLine();
            if (input.equals("0")) {
                break;
            }

            String[] tokens = input.split(" ");
            int beds = Integer.parseInt(tokens[0]);
            char[] customers = tokens[1].toCharArray();
            Set<Character> customerSet = new HashSet<>();
            Set<Character> walkAwaySet = new HashSet<>();

            for (char c : customers) {
                if (walkAwaySet.contains(c)) {
                    continue;
                }

                if (customerSet.contains(c)) {
                    customerSet.remove(c);
                } else {
                    if (customerSet.size() < beds) {
                        customerSet.add(c);
                    } else {
                        walkAwaySet.add(c);
                    }
                }
            }

            if (walkAwaySet.size() > 0) {
                sb.append(walkAwaySet.size()).append(" customer(s) walked away.\n");
            } else {
                sb.append("All customers tanned successfully.\n");
            }
        }

        System.out.println(sb);

    }
}
