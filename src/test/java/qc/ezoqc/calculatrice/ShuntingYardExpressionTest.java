package qc.ezoqc.calculatrice;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Queue;
import org.junit.Test;

public class ShuntingYardExpressionTest {

    final DecomposeExpressionArithmetique decompose = new DecomposeExpressionArithmetique();

    final ShuntingYardExpression shuntingYardExpression = new ShuntingYardExpression();

    @Test
    public void givenArithemtiqueWithNegatifNumberParenthesesAllSuportedOperateur_whenDecompse_decomposedReturned() {

        // GIVEN
        final String phraseArithemtique = "-1 + 3 + 5 - (-8 * 10 / -12) *sqrt(16)*19^21";
        final List<String> expressionShuntingYard = this.decompose.Decompose(phraseArithemtique);

        // WHEN
        final Queue resultat = shuntingYardExpression.construireExpression(expressionShuntingYard);

        System.out.println(resultat);
        System.out.println(expressionShuntingYard);

        // [-1, 3, +, 5, +, -8, 10, *, -12, /, 16, sqrt, *, 19, 21, ^, *, -]
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22
        // [-1, +, 3, +, 5, -, (, -8, *, 10, /, -12, ), *, sqrt, (, 16, ), *, 19, ^, 21]
        // 0 2 1 4 3 21 _ 5 7 6 9 8 _ 12 11 _ 10 _ 16 13 15 14

        // Then
        assertEquals(resultat.size(), expressionShuntingYard.size() - 4); // 4 parenthese de moins
        assertEquals(resultat.poll(), expressionShuntingYard.get(0));
        assertEquals(resultat.poll(), expressionShuntingYard.get(2));
        assertEquals(resultat.poll(), expressionShuntingYard.get(1));
        assertEquals(resultat.poll(), expressionShuntingYard.get(4));
        //
        // assertEquals(resultat.poll(), expressionShuntingYard.get(3));
        // assertEquals(resultat.poll(), expressionShuntingYard.get(5));
        // assertEquals(resultat.poll(), expressionShuntingYard.get(7));
        // assertEquals(resultat.poll(), expressionShuntingYard.get(5));
        // assertEquals(resultat.poll(), expressionShuntingYard.get(9));
        // assertEquals(resultat.poll(), expressionShuntingYard.get(8));
        // assertEquals(resultat.poll(), expressionShuntingYard.get(13));
        // assertEquals(resultat.poll(), expressionShuntingYard.get(11));
        // assertEquals(resultat.poll(), expressionShuntingYard.get(10));
        // assertEquals(resultat.poll(), expressionShuntingYard.get(16));
        // // assertEquals(resultat.poll(), expressionShuntingYard.get(13));
        // // assertEquals(resultat.poll(), expressionShuntingYard.get(15));
        // assertEquals(resultat.poll(), expressionShuntingYard.get(14));

    }

}
