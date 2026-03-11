import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long B = Long.parseLong(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, Long> itemMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String itemName = st.nextToken();
            long price = Long.parseLong(st.nextToken());
            itemMap.put(itemName, price);
        }
        
        long totalSum = 0;
        for (int i = 0; i < M; i++) {
            String targetItem = br.readLine();
            totalSum += itemMap.get(targetItem);
        }
        
        if (totalSum <= B) {
            System.out.println("acceptable");
        } else {
            System.out.println("unacceptable");
        }
    }
}