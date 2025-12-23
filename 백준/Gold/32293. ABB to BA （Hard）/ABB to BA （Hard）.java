import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();

            char[] stack = new char[n];
            int top = 0;

            for (int i = 0; i < n; i++) {
                char c = line.charAt(i);
                stack[top++] = c;

                int pendingAs = 0;
                
                while (top >= 3 && stack[top - 3] == 'A' && stack[top - 2] == 'B' && stack[top - 1] == 'B') {
                    top -= 3;           
                    stack[top++] = 'B'; 
                    pendingAs++;        
                }
                
                while (pendingAs > 0) {
                    stack[top++] = 'A';
                    pendingAs--;
                }
            }

            out.append(stack, 0, top).append('\n');
        }

        System.out.print(out);
    }
}