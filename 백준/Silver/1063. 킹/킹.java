import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        int[] dr = {0, 0, 1, -1, -1, -1, 1, 1};
        int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};
        Pos king = new Pos(Math.abs(a.charAt(1) - '0' - 8), a.charAt(0) - 'A');
        a = st.nextToken();
        Pos stone = new Pos(Math.abs(a.charAt(1) - '0' - 8), a.charAt(0) - 'A');
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String com = br.readLine();
            int dir = comToDir(com);
            Pos tempKing = new Pos(king.r + dr[dir], king.c + dc[dir]);
            Pos tempStone = new Pos(stone.r + dr[dir], stone.c + dc[dir]);

            if (tempKing.r == stone.r && tempKing.c == stone.c) {
                if (isValid(tempStone)) {
                    stone = tempStone;
                    king = tempKing;
                }
            } else if (isValid(tempKing)) {
                king = tempKing;
            }
        }
        char kingC = (char) ('A' + king.c);
        char stoneC = (char) ('A' + stone.c);
        int kingR = Math.abs(8 - king.r);
        int stoneR = Math.abs(8 - stone.r);

        System.out.println(kingC + "" + kingR + "\n" + stoneC + "" + stoneR);
    }
    private static int comToDir(String com) {
        switch (com) {
            case "R" : return 0;
            case "L" : return 1;
            case "B" : return 2;
            case "T" : return 3;
            case "RT" : return 4;
            case "LT" : return 5;
            case "RB" : return 6;
            case "LB" : return 7;
        }
        return -1;
    }
    private static boolean isValid(Pos p) {
        return p.r >= 0 && p.r < 8 && p.c >= 0 && p.c < 8;
    }
}
class Pos {
    int r;
    int c;

    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}