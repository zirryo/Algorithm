import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        int[] B = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st1.nextToken());
        }

        int offset = findOffset(B, A[0]);
        boolean forward = true;
        boolean backward = true;

        for (int i = 0; i < n; i++) {
            if (A[i] != B[(i + offset) % n]) {
                forward = false;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (A[i] != B[(offset - i + n) % n]) {
                backward = false;
                break;
            }
        }

        if (forward || backward) {
            System.out.println("good puzzle");
        } else {
            System.out.println("bad puzzle");
        }

    }

    private static int findOffset(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

}
