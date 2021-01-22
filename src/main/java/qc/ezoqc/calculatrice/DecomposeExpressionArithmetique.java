package qc.ezoqc.calculatrice;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class DecomposeExpressionArithmetique {

    final Pattern pattern = Pattern.compile("-?[0-9.]+|[-+*/()]|sqrt|\\^|[|]{2}");

    List<String> Decompose(
        final String expression) {

        final Matcher match = pattern.matcher(expression);
        final List<String> decomposee = new ArrayList<>();
        int index = 0;
        while (match.find()) {
            decomposee.add(match.group());
            if (decomposee.size() > 1) {
                final String beforeLast = decomposee.get(index - 1);
                final String last = decomposee.get(index);

                if (NumericTool.isNegatif(beforeLast) && NumericTool.isNegatif(last)) {
                    decomposee.remove(index);
                    decomposee.add("+");
                    decomposee.add(last);

                }
            }
            index++;
        }

        return decomposee;
    }

}
