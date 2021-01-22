package qc.ezoqc.calculatrice;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class DecomposeExpressionArithmetiqueTest {

    private final DecomposeExpressionArithmetique decompose = new DecomposeExpressionArithmetique();

    @Test
    public void givenExpress_whenDecompse_decomposedReturned() {

        // GIVEN
        final String phraseArithemtique = "-9 + 3 + 5 - (-2.5 * 3 / -2) *sqrt(4)*2^2";

        // WHEN
        final List<String> resultat = this.decompose.Decompose(phraseArithemtique);

        // Then
        assertEquals("-9", resultat.get(0));
        assertEquals("+", resultat.get(1));
        assertEquals("3", resultat.get(2));
        assertEquals("+", resultat.get(3));
        assertEquals("5", resultat.get(4));
        assertEquals("-", resultat.get(5));
        assertEquals("(", resultat.get(6));
        assertEquals("-2.5", resultat.get(7));
        assertEquals("*", resultat.get(8));
        assertEquals("3", resultat.get(9));
        assertEquals("/", resultat.get(10));
        assertEquals("-2", resultat.get(11));
        assertEquals(")", resultat.get(12));
        assertEquals("*", resultat.get(13));
        assertEquals("sqrt", resultat.get(14));
        assertEquals("(", resultat.get(15));
        assertEquals("4", resultat.get(16));
        assertEquals(")", resultat.get(17));
        assertEquals("*", resultat.get(18));
        assertEquals("2", resultat.get(19));
        assertEquals("^", resultat.get(20));
        assertEquals("2", resultat.get(21));
    }

    @Test
    public void operateur_negatif() {

        final String expression = "-9 -3";

        final List<String> res = decompose.Decompose(expression);

        System.out.println(res);
    }

}
