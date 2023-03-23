import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int Y = Integer.parseInt(br.readLine());

        if(X > 0 && Y > 0) System.out.println(1);
        if(X < 0 && Y > 0) System.out.println(2);
        if(X < 0 && Y < 0) System.out.println(3);
        if(X > 0 && Y < 0) System.out.println(4);
    }
}