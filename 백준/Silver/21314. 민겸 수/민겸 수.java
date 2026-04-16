import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(getMax(input));
        System.out.println(getMin(input));
    }

    private static String getMax(String s) {
        StringBuilder res = new StringBuilder();
        int mCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'M') {
                mCount++;
            } else {
                res.append("5");
                for (int j = 0; j < mCount; j++) {
                    res.append("0");
                }
                mCount = 0;
            }
        }

        if (mCount > 0) {
            for (int j = 0; j < mCount; j++) {
                res.append("1");
            }
        }

        return res.toString();
    }

    private static String getMin(String s) {
        StringBuilder res = new StringBuilder();
        int mCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'M') {
                mCount++;
            } else {
                if (mCount > 0) {
                    res.append("1");
                    for (int j = 0; j < mCount - 1; j++) {
                        res.append("0");
                    }
                    mCount = 0;
                }
                res.append("5");
            }
        }
        
        if (mCount > 0) {
            res.append("1");
            for (int j = 0; j < mCount - 1; j++) {
                res.append("0");
            }
        }

        return res.toString();
    }
}