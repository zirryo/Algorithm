import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        Set<String> cardSet = new HashSet<>();
        int[] count = new int[4];
        
        for (int i = 0; i < input.length(); i += 3) {
            String card = input.substring(i, i + 3);  
            char suit = card.charAt(0);  

            if (!cardSet.add(card)) {
                System.out.println("GRESKA");
                return;
            }

            switch (suit) {
                case 'P': count[0]++; break;
                case 'K': count[1]++; break;
                case 'H': count[2]++; break;
                case 'T': count[3]++; break;
            }
        }

        System.out.println((13 - count[0]) + " " + (13 - count[1]) + " " + (13 - count[2]) + " " + (13 - count[3]));
    }
}
