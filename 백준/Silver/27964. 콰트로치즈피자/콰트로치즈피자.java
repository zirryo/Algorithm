import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] toppings = br.readLine().split(" ");

        Set<String> cheeseSet = new HashSet<>();

        for (String topping : toppings) {
            if (topping.endsWith("Cheese")) {
                cheeseSet.add(topping);
            }
        }

        if (cheeseSet.size() >= 4) {
            System.out.println("yummy");
        } else {
            System.out.println("sad");
        }
    }
}
