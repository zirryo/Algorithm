import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> anagramSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            char[] word = br.readLine().toCharArray();
            Arrays.sort(word);  
            anagramSet.add(new String(word));  
        }

        System.out.println(anagramSet.size()); 
    }
}
