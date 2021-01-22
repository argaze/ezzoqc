package qc.ezoqc.calculatrice;

import java.util.List;

public class Calculatreur {

    public static void main(
        final String[] args) {

        final String phraseArithemtique = "-9 + 3 + 5 - (-2.5 * 3 / -2) *sqrt(4^2)/2";

        final DecomposeExpressionArithmetique decompose = new DecomposeExpressionArithmetique();
        final ShuntingYardExpression shuntingYardExpression = new ShuntingYardExpression();
        final ShuntingYardEvaluateur shuntingYardEvaluateur = new ShuntingYardEvaluateur();

        final List<String> expression = decompose.Decompose(phraseArithemtique);

        System.out.println(shuntingYardExpression.construireExpression(expression));

        System.out
            .println(shuntingYardEvaluateur.evaluerExpression(shuntingYardExpression.construireExpression(expression)));

    }

}
