package qc.ezoqc.calculatrice;

public enum Operateur {

        ADDITION("+", 1),
        SOUSTRACTION("-", 1),
        MULIPLICATION("*", 2),
        DIVISION("/", 2),
        RACINE_CARREE("sqrt", 3),
        PUISSANCE("^", 4),
        PARENTHESE_GAUCHE("(", 5),
        PARENTHESE_DROITE(")", 5);

    private final String operateur;

    private final int preseance;

    Operateur(
        final String operateur,
        final int preseance) {

        this.operateur = operateur;
        this.preseance = preseance;
    }

    public String getOperateur() {

        return operateur;
    }

    public int getPreseance() {

        return preseance;
    }

    public static Operateur getOperateur(
        final String operateur) {

        for (final Operateur v : values())
            if (v.getOperateur().equalsIgnoreCase(operateur))
                return v;
        throw new IllegalArgumentException("Operaateur non suporte " + operateur);
    }

    // public static class Constants {
    //
    // static final String CHAR_ADDITION = "+";
    //
    // static final String CHAR_SOUSTRACTION = "-";
    //
    // static final String CHAR_MULIPLICATION = "*";
    //
    // static final String CHAR_DIVISION = "/";
    //
    // static final String CHAR_RACINE_CARREE = "/";
    //
    // static final String CHAR_PUISSANCE = "sqrt";
    // }

}
