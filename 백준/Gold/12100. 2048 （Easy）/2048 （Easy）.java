import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, result = 2;
    static int[][] board;
    // 0-우, 1-하, 2-좌, 3-상
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makeOrder(new int[5], 0);
        System.out.println(result);
    }
    private static void makeOrder(int[] order, int depth) {
        if(depth == 5) {
            play2048(order);
            return;
        }
        for(int i = 0; i < 4; i++) {
            order[depth] = i;
            makeOrder(order, depth + 1);
        }
    }
    private static void play2048(int[] order) {
        int[][] tmp = new int[N][N];
        for(int i=0; i<N; i++) {
            tmp[i] = board[i].clone();
        }
        for(int i : order) {
            switch (i) {
                case 0 : {
                    tmp = moveRight(tmp);
                    break;
                }
                case 1 : {
                    tmp = moveDown(tmp);
                    break;
                }
                case 2 : {
                    tmp = moveLeft(tmp);
                    break;
                }
                case 3 : {
                    tmp = moveUp(tmp);
                    break;
                }
            }
        }
        getMax(tmp);
    }
    private static void getMax(int[][] arr) {
        int max = 2;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }
        result = Math.max(result, max);
    }
    private static int[][] moveRight(int[][] arr) {
        for(int i=0; i<N; i++) {
            Queue<Integer> q = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            for(int j=0; j<N; j++) {
                if(arr[i][j] != 0) stack.push(arr[i][j]);
            }
            while (!stack.isEmpty()) {
                int a = stack.pop();

                if(stack.isEmpty()) q.add(a);
                else {
                    int b = stack.pop();
                    if(a == b) q.add(a*2);
                    else {
                        q.add(a);
                        stack.push(b);
                    }
                }
            }
            int k = N-1;
            while (!q.isEmpty()) {
                arr[i][k] = q.poll();
                k--;
            }
            for(int j=k; j>=0; j--) arr[i][j] = 0;
        }
        return arr;
    }
    private static int[][] moveDown(int[][] arr) {
        for(int i=0; i<N; i++) {
            Queue<Integer> q = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            for(int j=0; j<N; j++) {
                if(arr[j][i] != 0) stack.push(arr[j][i]);
            }
            while (!stack.isEmpty()) {
                int a = stack.pop();

                if(stack.isEmpty()) q.add(a);
                else {
                    int b = stack.pop();
                    if(a == b) q.add(a*2);
                    else {
                        q.add(a);
                        stack.push(b);
                    }
                }
            }
            int k = N-1;
            while (!q.isEmpty()) {
                arr[k][i] = q.poll();
                k--;
            }
            for(int j=k; j>=0; j--) arr[j][i] = 0;
        }
        return arr;
    }
    private static int[][] moveLeft(int[][] arr) {
        for(int i=0; i<N; i++) {
            Queue<Integer> q = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            for(int j=N-1; j>=0; j--) {
                if(arr[i][j] != 0) stack.push(arr[i][j]);
            }
            while (!stack.isEmpty()) {
                int a = stack.pop();

                if(stack.isEmpty()) q.add(a);
                else {
                    int b = stack.pop();
                    if(a == b) q.add(a*2);
                    else {
                        q.add(a);
                        stack.push(b);
                    }
                }
            }
            int k = 0;
            while (!q.isEmpty()) {
                arr[i][k] = q.poll();
                k++;
            }
            for(int j=k; j<N; j++) arr[i][j] = 0;
        }
        return arr;
    }
    private static int[][] moveUp(int[][] arr) {
        for(int i=0; i<N; i++) {
            Queue<Integer> q = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            for(int j=N-1; j>=0; j--) {
                if(arr[j][i] != 0) stack.push(arr[j][i]);
            }
            while (!stack.isEmpty()) {
                int a = stack.pop();

                if(stack.isEmpty()) q.add(a);
                else {
                    int b = stack.pop();
                    if(a == b) q.add(a*2);
                    else {
                        q.add(a);
                        stack.push(b);
                    }
                }
            }
            int k = 0;
            while (!q.isEmpty()) {
                arr[k][i] = q.poll();
                k++;
            }
            for(int j=k; j<N; j++) arr[j][i] = 0;
        }
        return arr;
    }
}