import java.io.*;

public class Main {
    static long minFa = Long.MAX_VALUE;
    static final long LIMIT = 1000000000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int L = S.length();

        for (int i = 1; i <= 9 && i < L; i++) {
            long a1 = Long.parseLong(S.substring(0, i));

            for (int j = 1; j <= 9 && i + j < L; j++) {
                if (S.charAt(i) == '0') break;

                long a2 = Long.parseLong(S.substring(i, i + j));
                if (a2 <= a1) continue;
                long d = a2 - a1;

                checkNth(a2, i + j, S);

                long prevVal = a2;
                int currIdx = i + j;
                while (currIdx < L) {
                    long nextVal = prevVal + d;
                    if (nextVal >= LIMIT) break;

                    String nextStr = String.valueOf(nextVal);
                    if (S.startsWith(nextStr, currIdx)) {
                        currIdx += nextStr.length();
                        checkNth(nextVal, currIdx, S);
                        prevVal = nextVal;
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println(minFa == Long.MAX_VALUE ? 0 : minFa);
    }

    static void checkNth(long lastDiffValue, int curIdx, String S) {
        int L = S.length();
        int remainingLen = L - curIdx;

        if (remainingLen > 0 && remainingLen <= 9 && S.charAt(curIdx) != '0') {
            long an = Long.parseLong(S.substring(curIdx));
            if (an < LIMIT) {
                if (an % lastDiffValue == 0) {
                    long fa = an / lastDiffValue;
                    if (fa >= 2) {
                        minFa = Math.min(minFa, fa);
                    }
                }
            }
        }
    }
}