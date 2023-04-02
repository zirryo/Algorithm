import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int a = 0;
        int b = 0;
        for(int i=1; i<=28; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        for(int i=1; i<=30; i++) {
            if(!list.contains(i)) {
                if(a == 0) a = i;
                else {
                    b = i;
                    break;
                }
            }
        }
        if(a > b) System.out.println(b + "\n" + a);
        else System.out.println(a + "\n" + b);
    }
}