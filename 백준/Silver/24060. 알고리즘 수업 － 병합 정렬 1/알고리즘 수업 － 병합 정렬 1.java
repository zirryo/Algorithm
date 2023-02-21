import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, cnt = 0, result = -1;
    static int[] original, sort;
    public static void main(String[] args) throws IOException {
        init();
        mergeSort(0, N-1);
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        original = new int[N];
        sort = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int k=0; k<N; k++) original[k] = Integer.parseInt(st.nextToken());
    }
    private static void mergeSort(int l, int r) {
        if(l < r) {
            int mid = (l+r) / 2;
            mergeSort(l, mid); // 전반부 정렬
            mergeSort(mid+1, r); // 후반부 정렬
            merge(l, r, mid); // 병합
        }
    }
    private static void merge(int l, int r, int mid) {
        int i = l;
        int j = mid+1;
        int t = 0;

        while(i <= mid && j <= r) {
            if(original[i] <= original[j]) {
                sort[t++] = original[i++];
            } else {
                sort[t++] = original[j++];
            }
        }

        while(i<=mid) sort[t++] = original[i++]; // 왼쪽 배열이 남은 경우
        while(j<=r) sort[t++] = original[j++]; // 오른쪽 배열이 남은 경우
        i = l;
        t = 0;
        while (i<=r) {
            cnt++;
            if(cnt==K) {
                result = sort[t];
                break;
            }
            original[i++] = sort[t++]; // 결과 대입
        }
    }
}
/* 병합 정렬 (Merge Sort)
- 분할(Divide), 정복(Conquer), 결합(Combine)으로 정렬하는 방식

- 정렬되지 않은 리스트를 하나의 원소만 포함하는 n개의 리스트로 분할.
- 부분리스트가 1개가 될 때까지 반복해서 부분 배열을 정렬하고 병합.
- 부분리스트가 한 개가 되면 정렬(병합) 완료.
 */