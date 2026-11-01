import java.util.Arrays;

class Solution {

    public String[] solution(String[] files) {
        Arrays.sort(files, (f1, f2) -> {
            String[] parsed1 = parseFile(f1);
            String[] parsed2 = parseFile(f2);

            int headCompare = parsed1[0].toLowerCase().compareTo(parsed2[0].toLowerCase());
            if (headCompare != 0) {
                return headCompare;
            }

            int num1 = Integer.parseInt(parsed1[1]);
            int num2 = Integer.parseInt(parsed2[1]);

            return Integer.compare(num1, num2);
        });

        return files;
    }

    private String[] parseFile(String file) {
        int firstDigitIdx = -1;
        int numberEndIdx = -1;

        for (int i = 0; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i))) {
                firstDigitIdx = i;
                break;
            }
        }

        int length = 0;
        for (int i = firstDigitIdx; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i)) && length < 5) {
                length++;
            } else {
                break;
            }
        }
        numberEndIdx = firstDigitIdx + length;

        String head = file.substring(0, firstDigitIdx);
        String number = file.substring(firstDigitIdx, numberEndIdx);

        return new String[]{head, number};
    }
}