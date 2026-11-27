import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final char[][] PRIORITIES = {
        {'+', '-', '*'},
        {'+', '*', '-'},
        {'-', '+', '*'},
        {'-', '*', '+'},
        {'*', '+', '-'},
        {'*', '-', '+'}
    };

    public long solution(String expression) {
        List<Long> baseNumbers = new ArrayList<>();
        List<Character> baseOperators = new ArrayList<>();

        long currentNum = 0;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                baseNumbers.add(currentNum);
                baseOperators.add(ch);
                currentNum = 0;
            } else {
                currentNum = currentNum * 10 + (ch - '0');
            }
        }
        baseNumbers.add(currentNum);

        long maxPrize = 0;
        for (char[] priority : PRIORITIES) {
            long result = evaluate(baseNumbers, baseOperators, priority);
            maxPrize = Math.max(maxPrize, Math.abs(result));
        }

        return maxPrize;
    }

    private long evaluate(List<Long> baseNum, List<Character> baseOp, char[] priority) {
        List<Long> nums = new ArrayList<>(baseNum);
        List<Character> ops = new ArrayList<>(baseOp);

        for (char targetOp : priority) {
            int i = 0;
            while (i < ops.size()) {
                if (ops.get(i) == targetOp) {
                    long calculated = applyOp(nums.get(i), nums.get(i + 1), targetOp);
                    nums.set(i, calculated);
                    nums.remove(i + 1);
                    ops.remove(i);
                } else {
                    i++;
                }
            }
        }

        return nums.get(0);
    }

    private long applyOp(long a, long b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: return 0;
        }
    }
}