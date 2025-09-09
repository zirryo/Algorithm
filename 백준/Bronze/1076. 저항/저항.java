import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        String[] colors = {"black","brown","red","orange","yellow",
                "green","blue","violet","grey","white"};
        for (int i = 0; i < colors.length; i++) {
            map.put(colors[i], i);
        }

        String c1 = br.readLine().trim();
        String c2 = br.readLine().trim();
        String c3 = br.readLine().trim();

        long value = (map.get(c1) * 10L + map.get(c2)) * (long)Math.pow(10, map.get(c3));
        System.out.println(value);
    }
}
