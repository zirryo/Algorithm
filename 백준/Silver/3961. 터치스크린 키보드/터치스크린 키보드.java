import java.io.*;
import java.util.*;

public class Main {
    static int[][] distArr = new int[26][26];

    public static void main(String[] args) throws IOException {
        fillDistArr();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (!st.hasMoreTokens()) break;

            String userWord = st.nextToken();
            int l = Integer.parseInt(st.nextToken());

            List<WordInfo> list = new ArrayList<>();
            for (int i = 0; i < l; i++) {
                String programWord = br.readLine();
                int distance = getDist(userWord, programWord);
                list.add(new WordInfo(programWord, distance));
            }

            Collections.sort(list);

            StringBuilder sb = new StringBuilder();
            for (WordInfo w : list) {
                sb.append(w.word).append(" ").append(w.dist).append("\n");
            }
            System.out.print(sb);
        }
    }

    static void fillDistArr() {
        int[][] pos = new int[26][2];
        String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < keyboard[r].length(); c++) {
                int idx = keyboard[r].charAt(c) - 'a';
                pos[idx][0] = r;
                pos[idx][1] = c;
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                distArr[i][j] = Math.abs(pos[i][0] - pos[j][0]) + Math.abs(pos[i][1] - pos[j][1]);
            }
        }
    }

    static int getDist(String s1, String s2) {
        int totalDist = 0;
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            totalDist += distArr[s1.charAt(i) - 'a'][s2.charAt(i) - 'a'];
        }
        return totalDist;
    }

    static class WordInfo implements Comparable<WordInfo> {
        String word;
        int dist;

        WordInfo(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }

        @Override
        public int compareTo(WordInfo o) {
            if (this.dist != o.dist) return Integer.compare(this.dist, o.dist);
            return this.word.compareTo(o.word);
        }
    }
}