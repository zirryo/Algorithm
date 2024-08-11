import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BitSet set = new BitSet(33554432);

        String[] input = br.readLine().split(" ");
        for (String s : input) {
            int x = Integer.parseInt(s);
            if (!set.get(x)) {
                set.set(x);
                sb.append(x + " ");
            }
        }

        System.out.println(sb);
    }
}