import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] set = new boolean[21];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while(N-->0) {
            String[] s = br.readLine().split(" ");
            switch (s[0]) {
                case "add" : {
                    add(Integer.parseInt(s[1]));
                    break;
                }
                case "remove" : {
                    remove(Integer.parseInt(s[1]));
                    break;
                }
                case "check" : {
                    check(Integer.parseInt(s[1]));
                    break;
                }
                case "toggle" : {
                    toggle(Integer.parseInt(s[1]));
                    break;
                }
                case "all" : {
                    all();
                    break;
                }
                case "empty" : {
                    empty();
                    break;
                }
            }
        }
        System.out.println(sb);
    }
    static void add(int x) {
        set[x] = true;
    }
    static void remove(int x) {
        set[x] = false;
    }
    static void check(int x) {
        if(set[x]) sb.append(1).append("\n");
        else sb.append(0).append("\n");
    }
    static void toggle(int x) {
        set[x] = !set[x];
    }
    static void all() {
        Arrays.fill(set, true);
    }
    static void empty() {
        Arrays.fill(set, false);
    }
}