import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] in;
    static int[] post;
    static int[] idx; // in 배열의 인덱스 값을 담은 배열
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        in = new int[N+1];
        post = new int[N+1];
        idx = new int[N+1];

        StringTokenizer inorder = new StringTokenizer(br.readLine());
        StringTokenizer postorder = new StringTokenizer(br.readLine());


        for(int i=1; i<=N; i++) {
            in[i] = Integer.parseInt(inorder.nextToken());
            idx[in[i]] = i;
            post[i] = Integer.parseInt(postorder.nextToken());
        }

        getPre(1, N, 1, N); // 루트 -> 왼쪽노드 -> 오른쪽노드 순서로 출력
        System.out.println(sb);
    }

    private static void getPre(int inL, int inR, int postL, int postR) {
        if(inL > inR || postL > postR) return;

        int temp = post[postR]; // 포스트의 맨 뒤 -> 루트
        sb.append(temp).append(" ");

        int rootIdx = idx[temp]; // inorder 에 저장된 현재 루트의 인덱스 값
        int leftNodes = rootIdx - inL; // 현재 루트 기준 왼쪽 노드 수

        getPre(inL, rootIdx-1, postL, postL+leftNodes-1); // 왼쪽 탐색
        getPre(rootIdx+1, inR, postL + leftNodes, postR-1); // 오른쪽 탐색
    }

}