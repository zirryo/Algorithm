import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String baseType = input.split(" ")[0];
        String[] variables = input.substring(baseType.length()).split(",");
        StringBuilder result = new StringBuilder();
        StringBuilder variableName, symbols;

        for (int i = 0; i < variables.length; i++) {
            variables[i] = variables[i].trim();
            if (i == variables.length - 1) {
                variables[i] = variables[i].substring(0, variables[i].length() - 1);
            }

            variableName = new StringBuilder();
            symbols = new StringBuilder();
            for (int j = 0; j < variables[i].length(); j++) {
                char c = variables[i].charAt(j);
                if (Character.isAlphabetic(c)) {
                    variableName.append(c);
                } else {
                    symbols.append(c);
                }
            }

            symbols.reverse();
            String formattedSymbols = symbols.toString().replace("][", "[]");
            result.append(baseType + formattedSymbols + " " + variableName + ";\n");
        }

        System.out.print(result);
    }
}
