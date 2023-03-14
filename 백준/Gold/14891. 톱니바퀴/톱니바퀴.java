import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K, score = 0;
    static LinkedList<Integer>[] gear;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        gear = new LinkedList[5];
        for(int i=1; i<=4; i++) {
            String s = br.readLine();
            gear[i] = new LinkedList<>();
            for(int j=0; j<8; j++) {
                gear[i].add(s.charAt(j) - '0'); // 0번째 인덱스를 12시 방향이라고 가정

            }
        }
        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken());
            int command = Integer.parseInt(st.nextToken());

            leftGear(gearNum - 1, -command); // 인접 기어는 반대로 회전
            rightGear(gearNum + 1, -command);
            turnGear(gearNum, command);
        }
        getScore();
        System.out.println(score);
    }
    private static void turnGear(int gearNum, int dir) {
        if(dir == 1) gear[gearNum].addFirst(gear[gearNum].pollLast());
        else gear[gearNum].addLast(gear[gearNum].pollFirst());
    }
    private static void leftGear(int gearNum, int dir) { // 왼쪽 기어 확인
        if(gearNum < 1 || gearNum > 4) return;
        if(isDiffPole(gearNum, gearNum + 1)) {
            leftGear(gearNum - 1, -dir);
            turnGear(gearNum, dir);
        }
    }
    private static void rightGear(int gearNum, int dir) { // 오른쪽 기어 확인
        if(gearNum < 1 || gearNum > 4) return;
        if(isDiffPole(gearNum - 1, gearNum)) {
            rightGear(gearNum + 1, -dir);
            turnGear(gearNum, dir);
        }
    }
    private static boolean isDiffPole(int gear1, int gear2) { // 인접한 두 기어의 극성 확인
        return gear[gear1].get(2) != gear[gear2].get(6);
    }
    private static void getScore() {
        if(Objects.equals(gear[1].get(0), 1)) score += 1;
        if(Objects.equals(gear[2].get(0), 1)) score += 2;
        if(Objects.equals(gear[3].get(0), 1)) score += 4;
        if(Objects.equals(gear[4].get(0), 1)) score += 8;
    }
}