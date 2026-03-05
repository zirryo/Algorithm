import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        String before = br.readLine();
        String after = br.readLine();
        
        boolean isSuccess = true;
        
        if (N % 2 == 0) {
            if (!before.equals(after)) {
                isSuccess = false;
            }
        } else {
            for (int i = 0; i < before.length(); i++) {
                if (before.charAt(i) == after.charAt(i)) {
                    isSuccess = false;
                    break;
                }
            }
        }
        
        if (isSuccess) {
            System.out.println("Deletion succeeded");
        } else {
            System.out.println("Deletion failed");
        }
    }
}