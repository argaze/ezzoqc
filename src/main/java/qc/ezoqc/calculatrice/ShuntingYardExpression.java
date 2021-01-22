package qc.ezoqc.calculatrice;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ShuntingYardExpression {

    public Queue construireExpression(
        final List<String> expression) {

        final Queue<String> queue = new LinkedList<>();

        final Stack<Operateur> pileOperateur = new Stack<>();

        for (int i = 0; i < expression.size(); i++) {

            final String element = expression.get(i);

            if (NumericTool.isNumeric(element))
                queue.add(element);
            else
                traiterOperateurs(queue, pileOperateur, element);

        }
        traiterRestesOperateurTrouveesDansLapileSelonPreseance(queue, pileOperateur);
        return queue;

    }

    private void traiterRestesOperateurTrouveesDansLapileSelonPreseance(
            final Queue<String> queue,
            final Stack<Operateur> pileOperateur) {

        while (!pileOperateur.isEmpty()) {
            if (pileOperateur.peek().equals(Operateur.PARENTHESE_GAUCHE))
                throw new RuntimeException("Expression non valid");
            depileEtAjouterElementALaFile(queue, pileOperateur);
        }
    }

    private void traiterOperateurs(
        final Queue<String> queue,
        final Stack<Operateur> pileOperateur,
        final String element) {

        final Operateur operateurTrouve = Operateur.getOperateur(element);

        if (Operateur.PARENTHESE_GAUCHE.equals(operateurTrouve))
            pileOperateur.push(operateurTrouve);

        else if (Operateur.PARENTHESE_DROITE.equals(operateurTrouve)) {
            traiterOperateursEntreParentSelonPreseanceheEnIgnorantCelleDeGauche(queue, pileOperateur);
        } else {
            traiterOperateursSelonPreseanceEnIgorantParentheseDroite(queue, pileOperateur, operateurTrouve);

        }
    }

    private void traiterOperateursSelonPreseanceEnIgorantParentheseDroite(
        final Queue<String> queue,
        final Stack<Operateur> pileOperateur,
        final Operateur operateurTrouve) {

        while (!pileOperateur.isEmpty()
            && !Operateur.PARENTHESE_GAUCHE.equals(pileOperateur.peek())
            && operateurTrouve.getPreseance() <= pileOperateur.peek().getPreseance()) {

            depileEtAjouterElementALaFile(queue, pileOperateur);
        }
        pileOperateur.push(operateurTrouve);
    }

    private void traiterOperateursEntreParentSelonPreseanceheEnIgnorantCelleDeGauche(
        final Queue<String> queue,
        final Stack<Operateur> pileOperateur) {

        while (!pileOperateur.isEmpty() && !Operateur.PARENTHESE_GAUCHE.equals(pileOperateur.peek())) {
            depileEtAjouterElementALaFile(queue, pileOperateur);
        }
        pileOperateur.pop();
    }

    private void depileEtAjouterElementALaFile(
        final Queue<String> queue,
        final Stack<Operateur> pileOperateur) {

        final String operateur = pileOperateur.pop().getOperateur();
        queue.add(operateur);
    }
}
