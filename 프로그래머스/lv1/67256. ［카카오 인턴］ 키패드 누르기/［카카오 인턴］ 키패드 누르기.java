class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int leftPos = 10;
        int rightPos = 12;
        for(int i=0; i<numbers.length; i++) {
            int x = numbers[i];
            if(x % 3 == 1) {
                sb.append("L");
                leftPos = x;
            } else if(x % 3 == 2 || x == 0) {
                if(x == 0) x = 11;
                int distL = (Math.abs(x - leftPos) / 3) + (Math.abs(x - leftPos) % 3);
                int distR = (Math.abs(x - rightPos) / 3) + (Math.abs(x - rightPos) % 3);
                
                if(distL == distR) {
                    if(hand.equals("left")) {
                        sb.append("L");
                        leftPos = x;
                    } else {
                        sb.append("R");
                        rightPos = x;
                    }
                } else if(distL > distR) {
                    sb.append("R");
                    rightPos = x;
                } else {
                    sb.append("L");
                    leftPos = x;
                }
            } else {
                sb.append("R");
                rightPos = numbers[i];
            }
        }
        return sb.toString();
    }
}