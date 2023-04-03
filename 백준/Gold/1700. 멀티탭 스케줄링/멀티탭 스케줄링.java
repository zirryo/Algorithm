import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static Set<Integer> pluggedSet = new HashSet<>();
    static int N, K, result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < K; i++) {
            if(pluggedSet.contains(arr[i])) continue; // 이미 꽂혀있는 경우
            if(pluggedSet.size() < N) { // 새로 꽂아야 하는데 빈자리가 있는 경우
                pluggedSet.add(arr[i]);
            } else { // 새로 꽂아야 하는데 빈자리가 없는 경우
                int unplug = 0; // 다시 사용하지 않을 플러그
                int farFlug = 0; // 가장 늦게 다시 사용되는 플러그
                int howFar = 0; // 다시 사용되는 시점
                for(int j : pluggedSet) {
                    boolean noMoreUse = true;
                    for(int k = i+1; k < K; k++) {
                        if(arr[k] == j) {
                            noMoreUse = false;
                            if(howFar < k) {
                                howFar = k;
                                farFlug = j;
                            }
                            break;
                        }
                    }
                    if(noMoreUse) {
                        unplug = j;
                        break;
                    }
                }
                if(unplug != 0) {
                    pluggedSet.remove(unplug);
                } else {
                    pluggedSet.remove(farFlug);
                }
                pluggedSet.add(arr[i]);
                result++;
            }
        }
        System.out.println(result);
    }
}