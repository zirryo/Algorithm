class Solution {

    private int[] suffixSum;

    public int solution(int[] numbers, int target) {
        int n = numbers.length;
        suffixSum = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + numbers[i];
        }

        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int currentSum) {
        if (index == numbers.length) {
            return currentSum == target ? 1 : 0;
        }

        if (currentSum + suffixSum[index] < target || 
            currentSum - suffixSum[index] > target) {
            return 0;
        }

        return dfs(numbers, target, index + 1, currentSum + numbers[index])
             + dfs(numbers, target, index + 1, currentSum - numbers[index]);
    }
}