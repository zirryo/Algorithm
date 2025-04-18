import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String skills = br.readLine();

        int result = 0;
        int lCount = 0; 
        int sCount = 0;

        for (int i = 0; i < N; i++) {
            char skill = skills.charAt(i);

            if (skill >= '1' && skill <= '9') {
                result++;
            } else if (skill == 'L') {
                lCount++; 
            } else if (skill == 'S') {
                sCount++; 
            } else if (skill == 'R') {
                if (lCount > 0) {
                    lCount--; 
                    result++;
                } else {
                    break; 
                }
            } else if (skill == 'K') {
                if (sCount > 0) {
                    sCount--; 
                    result++;
                } else {
                    break; 
                }
            }
        }

        System.out.println(result);
    }
}
