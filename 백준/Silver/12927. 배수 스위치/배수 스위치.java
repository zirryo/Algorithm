import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] bulbs = br.readLine().toCharArray();
        int count = 0;

        for (int i = 0; i < bulbs.length; i++) {
            if (bulbs[i] == 'Y') {
                count++;
                for (int j = i; j < bulbs.length; j += (i + 1)) {
                    bulbs[j] = (bulbs[j] == 'Y') ? 'N' : 'Y';
                }
            }
        }
        
        System.out.println(count);
    }
}
