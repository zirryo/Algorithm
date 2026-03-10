import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long K, count = 0;
    static int[] A;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        heapSort();

        if (!found) {
            System.out.println("-1");
        }
    }

    static void heapSort() {
        buildMinHeap(N);
        for (int i = N; i >= 2; i--) {
            swap(1, i);
            if (found) return;
            heapify(1, i - 1);
            if (found) return;
        }
    }

    static void buildMinHeap(int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(i, n);
            if (found) return;
        }
    }

    static void heapify(int k, int n) {
        int left = 2 * k;
        int right = 2 * k + 1;
        int smaller;

        if (right <= n) {
            if (A[left] < A[right]) smaller = left;
            else smaller = right;
        } else if (left <= n) {
            smaller = left;
        } else {
            return;
        }

        if (A[smaller] < A[k]) {
            swap(k, smaller);
            if (found) return;
            heapify(smaller, n);
        }
    }

    static void swap(int i, int j) {
        count++;
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;

        if (count == K) {
            int n1 = A[i];
            int n2 = A[j];
            if (n1 > n2) {
                int t = n1; n1 = n2; n2 = t;
            }
            System.out.println(n1 + " " + n2);
            found = true;
        }
    }
}