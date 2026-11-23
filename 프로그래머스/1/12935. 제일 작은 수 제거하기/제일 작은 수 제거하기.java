class Solution {

    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int minVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }

        int[] answer = new int[arr.length - 1];
        int index = 0;
        for (int num : arr) {
            if (num != minVal) {
                answer[index++] = num;
            }
        }

        return answer;
    }
}