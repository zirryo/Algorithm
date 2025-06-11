import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Integer> killCount = new LinkedHashMap<>();
        String line;
        int total = 0;

        while (!(line = br.readLine()).equals("0")) {
            killCount.put(line, killCount.getOrDefault(line, 0) + 1);
            total++;
        }

        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : killCount.entrySet()) {
            output.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        output.append("Grand Total: " + total);
        System.out.println(output);
    }
}
