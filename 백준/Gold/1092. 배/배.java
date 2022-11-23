import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> crane = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());


        int M = Integer.parseInt(br.readLine());

        List<Integer> boxes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        if(boxes.get(0) > crane.get(0)) { // 크레인이 박스를 들 수 없으면 -1
            System.out.println(-1);
            System.exit(0);
        }

        while(!boxes.isEmpty()) {
            cnt++;
            for(Integer curC : crane) {
                for(int i=0; i< boxes.size(); i++) {
                    if(curC >= boxes.get(i)) {
                        boxes.remove(i);
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}