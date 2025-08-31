import java.io.*;
import java.util.*;

public class Main {
    static class Key {
        int button, count;
        Key(int b, int c) { button = b; count = c; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        String msg = br.readLine();

        Map<Character, Key> map = new HashMap<>();
        map.put(' ', new Key(1, 1));
        String[] keys = {
                " ",
                "",
                "ABC",
                "DEF",
                "GHI",
                "JKL",
                "MNO",
                "PQRS",
                "TUV",
                "WXYZ"
        };
        for (int button = 2; button <= 9; button++) {
            String s = keys[button];
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), new Key(button, i + 1));
            }
        }

        int total = 0;
        int prevButton = -1;
        for (char c : msg.toCharArray()) {
            Key k = map.get(c);
            if (prevButton != 1 && prevButton == k.button) total += w;
            total += k.count * p;
            prevButton = k.button;
        }

        System.out.println(total);
    }
}
