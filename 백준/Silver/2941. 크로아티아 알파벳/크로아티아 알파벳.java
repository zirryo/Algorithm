import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        
        input = input.replace("c=", "0");
        input = input.replace("c-", "1");
        input = input.replace("dz=", "2");
        input = input.replace("d-", "3");
        input = input.replace("lj", "4");
        input = input.replace("nj", "5");
        input = input.replace("s=", "6");
        input = input.replace("z=", "7");
        
        System.out.println(input.length());
    }
}
