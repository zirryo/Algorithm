import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    
    static int[] parsePosition(String col, String row) {
        return new int[]{col.charAt(0) - 'A', row.charAt(0) - '1'};
    }
    
    static boolean sameColor(int[] a, int[] b) {
        return (a[0] + a[1]) % 2 == (b[0] + b[1]) % 2;
    }
    
    static boolean onSameDiagonal(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) == Math.abs(a[1] - b[1]);
    }
    
    static String toChessPos(int[] pos) {
        return (char)(pos[0] + 'A') + " " + (pos[1] + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] start = parsePosition(st.nextToken(), st.nextToken());
            int[] end = parsePosition(st.nextToken(), st.nextToken());

            if (!sameColor(start, end)) {
                sb.append("Impossible\n");
            } else if (start[0] == end[0] && start[1] == end[1]) {
                sb.append("0 ").append(toChessPos(start)).append("\n");
            } else if (onSameDiagonal(start, end)) {
                sb.append("1 ").append(toChessPos(start)).append(" ").append(toChessPos(end)).append("\n");
            } else {
                boolean found = false;
                for (int x = 0; x < 8 && !found; x++) {
                    for (int y = 0; y < 8 && !found; y++) {
                        int[] mid = new int[]{x, y};
                        if (onSameDiagonal(start, mid) && onSameDiagonal(mid, end)) {
                            sb.append("2 ")
                                    .append(toChessPos(start)).append(" ")
                                    .append(toChessPos(mid)).append(" ")
                                    .append(toChessPos(end)).append("\n");
                            found = true;
                        }
                    }
                }
            }
        }

        System.out.print(sb);
    }
}
