package qc.ezoqc.calculatrice;

import java.util.regex.Pattern;

public class NumericTool {

    public static boolean isNumeric(
        final String strNum) {

        final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static boolean isNegatif(
        final String strNum) {

        final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
