import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            if (line.equals("0")) break;

            String[] steps = line.trim().split("\\s+");
            List<Integer> errors = new ArrayList<>();
            boolean hasDip = false;
            boolean hasTwirl = false;
            boolean hasHop = false;
            boolean startsWithJiggle = steps[0].equals("jiggle");

            List<Integer> dipIndices = new ArrayList<>();
            for (int i = 0; i < steps.length; i++) {
                if (steps[i].equals("dip")) {
                    hasDip = true;
                    boolean isValid = false;
                    if (i >= 1 && steps[i - 1].equals("jiggle")) isValid = true;
                    if (i >= 2 && steps[i - 2].equals("jiggle")) isValid = true;
                    if (i + 1 < steps.length && steps[i + 1].equals("twirl")) isValid = true;
                    if (!isValid) dipIndices.add(i);  // 규칙 1 위반
                }
                if (steps[i].equals("twirl")) hasTwirl = true;
                if (steps[i].equals("hop")) hasHop = true;
            }
            if (!dipIndices.isEmpty()) errors.add(1);

            // 규칙 2
            int len = steps.length;
            if (len < 3 || !(steps[len - 3].equals("clap") && steps[len - 2].equals("stomp") && steps[len - 1].equals("clap"))) {
                errors.add(2);
            }

            // 규칙 3
            if (hasTwirl && !hasHop) {
                errors.add(3);
            }

            // 규칙 4
            if (startsWithJiggle) {
                errors.add(4);
            }

            // 규칙 5
            if (!hasDip) {
                errors.add(5);
            }

            if (errors.isEmpty()) {
                output.append("form ok: ").append(line).append("\n");
            } else {
                if (errors.size() == 1) {
                    output.append("form error ").append(errors.get(0)).append(": ");
                } else {
                    output.append("form errors ");
                    for (int i = 0; i < errors.size(); i++) {
                        if (i > 0) {
                            if (i == errors.size() - 1) {
                                output.append(" and ");
                            } else {
                                output.append(", ");
                            }
                        }
                        output.append(errors.get(i));
                    }
                    output.append(": ");
                }

                if (errors.contains(1)) {
                    for (int i = 0; i < steps.length; i++) {
                        if (dipIndices.contains(i)) {
                            output.append("DIP");
                        } else {
                            output.append(steps[i]);
                        }
                        if (i != steps.length - 1) output.append(" ");
                    }
                } else {
                    output.append(line);
                }
                output.append("\n");
            }
        }

        System.out.print(output);
    }
}
