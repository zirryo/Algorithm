import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<String> suffixes = new ArrayList<>();
        
        for (int i = 0; i < input.length(); i++) {
            suffixes.add(input.substring(i));
        }
        
        Collections.sort(suffixes);
        
        StringBuilder sb = new StringBuilder();
        for (String suffix : suffixes) {
            sb.append(suffix).append("\n");
        }

        System.out.print(sb);
    }
}
