import java.util.ArrayList;

class Solution {
    int[] discountRate = {10, 20, 30, 40};
    int usersLen, emoticonsLen;
    ArrayList<int[]> answerList;
    public int[] solution(int[][] users, int[] emoticons) {
        usersLen = users.length;
        emoticonsLen = emoticons.length;
        answerList = new ArrayList<>();

        dfs(users, emoticons, new int[emoticonsLen], 0);
        answerList.sort(((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]));
        return answerList.get(0);
    }
    public void dfs(int[][] users, int[] emoticons, int[] discountList, int depth) {
        if(depth == emoticonsLen) {
            int subscriber = 0;
            int totalAmount = 0;
            for(int i=0; i<usersLen; i++) {
                int sum = 0;
                for(int j=0; j<emoticonsLen; j++) {
                    if(discountList[j] >= users[i][0]) {
                        sum += (emoticons[j] * (100 - discountList[j]) / 100);
                    }
                }
                if(sum >= users[i][1]) subscriber++;
                else totalAmount += sum;
            }
            answerList.add(new int[]{subscriber, totalAmount});
        } else {
           for(int i=0; i<4; i++) {
               discountList[depth] = discountRate[i];
               dfs(users, emoticons, discountList, depth+1);
           }
        }
    }
}