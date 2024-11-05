import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  
        int result = 0;  

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGroupWord(word)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean isGroupWord(String word) {
        boolean[] appeared = new boolean[26];  
        char prevChar = '\0';  

        for (int j = 0; j < word.length(); j++) {
            char currChar = word.charAt(j);
            if (currChar != prevChar) {  
                if (appeared[currChar - 'a']) {  
                    return false;  
                }
                appeared[currChar - 'a'] = true;  
                prevChar = currChar; 
            } 
        }
        return true; 
    }
}
