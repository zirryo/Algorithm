import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> asc = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int zero = 0;

        while(N-->0) {
            int k = Integer.parseInt(br.readLine());

            if(k > 0) {
                desc.add(k);
            } else if (k == 0) {
                zero++;
            } else asc.add(k);
        }

        while(desc.size()>=2) {
            int x = desc.poll();
            int y = desc.poll();
            if(x==1 || y==1) result += (x+y);
            else result += (x*y);
        }
        while(!desc.isEmpty()) {
            result += desc.poll();
        }

        while(asc.size()>=2) {
            result += (asc.poll() * asc.poll());
        }

        if(!asc.isEmpty() && zero != 0) asc.poll();
        else if (!asc.isEmpty()) result += asc.poll();

        System.out.println(result);
    }

}