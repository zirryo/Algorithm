import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] cardList;
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        // bufferedReader 는 한 줄 단위로 읽음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cards = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        cardList = new int[cards];
        StringTokenizer cardString = new StringTokenizer(br.readLine());
        for(int i=0; i<cards; i++) {
            cardList[i] = Integer.parseInt(cardString.nextToken());
        }
        int sum;
        for(int j=0; j<cards-2; j++) {
            for(int k=j+1; k<cards-1; k++) {
                for(int l=k+1; l<cards; l++) {
                    sum = cardList[j] + cardList[k] + cardList[l];
                    if(sum<limit) result = Math.max(result,sum);
                    else if (sum==limit) {
                        System.out.println(limit);
                        return;
                    }
                }
            }
        }
        System.out.println(result);
    }

}