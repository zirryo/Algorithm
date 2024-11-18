import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);

        System.out.println(findCycleLength(A, P));
    }

    public static int findCycleLength(int start, int power) {
        Map<Integer, Integer> sequence = new HashMap<>();
        int current = start;
        int index = 0;

        while (!sequence.containsKey(current)) {
            sequence.put(current, index++);
            current = getNextNumber(current, power);
        }

        return sequence.get(current);
    }

    public static int getNextNumber(int num, int power) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, power);
            num /= 10;
        }
        return sum;
    }
}
