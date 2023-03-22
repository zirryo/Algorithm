import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r, c, k;
    static int row = 3, col = 3;
    static int[][] arr = new int[100][100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = -1;

        while(time++ < 100) {
            if(arr[r][c] == k) break;

            if(row >= col) calR();
            else calC();
        }
        if(time >= 101) time = -1;
        System.out.println(time);
    }
    private static void calR() {
        HashMap<Integer, Integer> map;
        int tempCol = 0;
        for(int i=0; i<row; i++) {
            map = new HashMap<>();
            for(int j=0; j<col; j++) {
                if(arr[i][j] == 0) continue;
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                arr[i][j] = 0;
            }
            List<Map.Entry<Integer, Integer>> list = sortMap(map);
            int size = Math.min(map.size() * 2, 100);

            for(int j=0; j<size; j += 2) {
                arr[i][j] = list.get(j/2).getKey();
                arr[i][j+1] = list.get(j/2).getValue();
            }
            tempCol = Math.max(tempCol, size);
        }
        col = tempCol;
    }
    private static void calC() {
        HashMap<Integer, Integer> map;
        int tempRow = 0;
        for(int j=0; j<col; j++) {
            map = new HashMap<>();
            for(int i=0; i<row; i++) {
                if(arr[i][j] == 0) continue;
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                arr[i][j] = 0;
            }
            List<Map.Entry<Integer, Integer>> list = sortMap(map);
            int size = Math.min(map.size() * 2, 100);

            for(int i=0; i<size; i += 2) {
                arr[i][j] = list.get(i/2).getKey();
                arr[i+1][j] = list.get(i/2).getValue();
            }
            tempRow = Math.max(tempRow, size);
        }
        row = tempRow;
    }
    private static List<Map.Entry<Integer, Integer>> sortMap(HashMap<Integer, Integer> hashMap) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(hashMap.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if(o1.getValue().equals(o2.getValue())) {
                return o1.getKey() - o2.getKey();
            }
            return o1.getValue() - o2.getValue();
        });
        return list;
    }
}