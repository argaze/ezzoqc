package qc.ezoqc.calculatrice;

import java.util.Queue;
import java.util.Stack;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class ShuntingYardEvaluateur {

    public Double evaluerExpression(
        final Queue<String> expression) {

        final Stack<Double> evaluate = new Stack<>();

        while (!expression.isEmpty()) {

            final String element = expression.poll();

            if (NumericTool.isNumeric(element))
                evaluate.push(Double.valueOf(element));
            else {
                Double resultat = 0.0d;
                final Operateur operateur = Operateur.getOperateur(element);

                switch (operateur) {
                    case ADDITION:
                        resultat = evaluate.pop() + evaluate.pop();
                        break;
                    case SOUSTRACTION:
                        final Double soustractionOperand1 = evaluate.pop();
                        final Double soustractionOperand2 = evaluate.pop();
                        resultat = soustractionOperand2 - soustractionOperand1;
                        break;
                    case MULIPLICATION:
                        resultat = evaluate.pop() * evaluate.pop();
                        break;
                    case DIVISION:
                        final Double dvisionOperand1 = evaluate.pop();
                        final Double dvisionOperand2 = evaluate.pop();
                        resultat = dvisionOperand2 / dvisionOperand1;
                        break;
                    case RACINE_CARREE:
                        resultat = Math.sqrt(evaluate.pop());
                        break;
                    case PUISSANCE:
                        final Double exposant = evaluate.pop();
                        final Double base = evaluate.pop();
                        // TODO: ajout exception si
                        resultat = Math.pow(base, Double.valueOf(exposant));
                        break;
                }
                evaluate.push(resultat);

            }
        }
        return evaluate.pop();

    }

}
