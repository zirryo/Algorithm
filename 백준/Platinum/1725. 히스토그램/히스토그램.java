import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0L;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> idxStack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!idxStack.isEmpty() && arr[idxStack.peek()] >= arr[i]) {
                int h = arr[idxStack.pop()];
                long w = idxStack.isEmpty() ? i : i - 1 - idxStack.peek();
                result = Math.max(result, h * w);
            }

            idxStack.push(i);
        }

        while (!idxStack.isEmpty()) {
            int h = arr[idxStack.pop()];
            long w = idxStack.isEmpty() ? N : N - 1 - idxStack.peek();
            result = Math.max(result, h * w);
        }

        System.out.println(result);
    }
}