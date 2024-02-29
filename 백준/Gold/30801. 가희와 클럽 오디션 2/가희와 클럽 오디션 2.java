import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String keynote = br.readLine() + "..";
        String input = br.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        // 1 - 좌하(LD, RU!), 2 - 하(S, W!), 3 - 우하(RD, LU!), 4 - 좌(A, D!)
        // 6 - 우(D, A!), 7 - 좌상(LU, RD!), 8 - 상(W, S!), 9 - 우상(RU, LD!)

        for (int i = 0; i < keynote.length() - 1; i++) {
            char c = keynote.charAt(i);
            int keyNum = -1;
            if (c == 'W' || c == 'A' || c == 'S' || c == 'D') {

                switch (c) {
                    case 'W': {
                        keyNum = 8;
                        break;
                    }
                    case 'A': {
                        keyNum = 4;
                        break;
                    }
                    case 'S': {
                        keyNum = 2;
                        break;
                    }
                    case 'D': {
                        keyNum = 6;
                        break;
                    }
                }
                if (keynote.charAt(i+1) == '!') keyNum = (10 - keyNum);
            } else if (c == 'L' || c == 'R') {
                if (c == 'L') keyNum = 1;
                else keyNum = 3;

                if (keynote.charAt(i + 1) == 'U') keyNum += 6;
                if (keynote.charAt(i + 2) == '!') keyNum = (10 - keyNum);
                i++;
            } else continue;

            list.add(keyNum);
        }

        int matched = 0;
        int hit = -1;
        int level = list.size();

        for (char c : input.toCharArray()) {
            if (c == 'W') {
                hit = 8;
            } else if (c == 'A') {
                hit = 4;
            } else if (c == 'S') {
                hit = 2;
            } else if (c == 'D') {
                hit = 6;
            } else {
                hit = c - '0';
            }

            if (matched == level) {
                matched = 0;
                continue;
            }

            if (list.get(matched) == hit) matched++;
            else matched = 0;
        }

        if (matched == level) System.out.println("Yes");
        else System.out.println("No");
    }
}