import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        LinkedList<Integer> deck = new LinkedList<>();

        for (int i = N; i >= 1; i--) {
            deck.addFirst(i);

            for (int j = 0; j < i; j++) {
                deck.addFirst(deck.removeLast());
            }
        }
        
        for (int num : deck) {
            System.out.println(num);
        }
    }
}
