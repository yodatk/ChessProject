package ChessGame.Logic;

import javafx.util.Pair;

public class Coordinates {
    public static Pair<Column,Row> A1 = new Pair<>(Column.A,Row.ONE);
    public static Pair<Column,Row> A2 = new Pair<>(Column.A,Row.TWO);
    public static Pair<Column,Row> A3 = new Pair<>(Column.A,Row.THREE);
    public static Pair<Column,Row> A4 = new Pair<>(Column.A,Row.FOUR);
    public static Pair<Column,Row> A5 = new Pair<>(Column.A,Row.FIVE);
    public static Pair<Column,Row> A6 = new Pair<>(Column.A,Row.SIX);
    public static Pair<Column,Row> A7 = new Pair<>(Column.A,Row.SEVEN);
    public static Pair<Column,Row> A8 = new Pair<>(Column.A,Row.EIGHT);

    public static Pair<Column,Row> B1 = new Pair<>(Column.B,Row.ONE);
    public static Pair<Column,Row> B2 = new Pair<>(Column.B,Row.TWO);
    public static Pair<Column,Row> B3 = new Pair<>(Column.B,Row.THREE);
    public static Pair<Column,Row> B4 = new Pair<>(Column.B,Row.FOUR);
    public static Pair<Column,Row> B5 = new Pair<>(Column.B,Row.FIVE);
    public static Pair<Column,Row> B6 = new Pair<>(Column.B,Row.SIX);
    public static Pair<Column,Row> B7 = new Pair<>(Column.B,Row.SEVEN);
    public static Pair<Column,Row> B8 = new Pair<>(Column.B,Row.EIGHT);

    public static Pair<Column,Row> C1 = new Pair<>(Column.C,Row.ONE);
    public static Pair<Column,Row> C2 = new Pair<>(Column.C,Row.TWO);
    public static Pair<Column,Row> C3 = new Pair<>(Column.C,Row.THREE);
    public static Pair<Column,Row> C4 = new Pair<>(Column.C,Row.FOUR);
    public static Pair<Column,Row> C5 = new Pair<>(Column.C,Row.FIVE);
    public static Pair<Column,Row> C6 = new Pair<>(Column.C,Row.SIX);
    public static Pair<Column,Row> C7 = new Pair<>(Column.C,Row.SEVEN);
    public static Pair<Column,Row> C8 = new Pair<>(Column.C,Row.EIGHT);

    public static Pair<Column,Row> D1 = new Pair<>(Column.D,Row.ONE);
    public static Pair<Column,Row> D2 = new Pair<>(Column.D,Row.TWO);
    public static Pair<Column,Row> D3 = new Pair<>(Column.D,Row.THREE);
    public static Pair<Column,Row> D4 = new Pair<>(Column.D,Row.FOUR);
    public static Pair<Column,Row> D5 = new Pair<>(Column.D,Row.FIVE);
    public static Pair<Column,Row> D6 = new Pair<>(Column.D,Row.SIX);
    public static Pair<Column,Row> D7 = new Pair<>(Column.D,Row.SEVEN);
    public static Pair<Column,Row> D8 = new Pair<>(Column.D,Row.EIGHT);

    public static Pair<Column,Row> E1 = new Pair<>(Column.E,Row.ONE);
    public static Pair<Column,Row> E2 = new Pair<>(Column.E,Row.TWO);
    public static Pair<Column,Row> E3 = new Pair<>(Column.E,Row.THREE);
    public static Pair<Column,Row> E4 = new Pair<>(Column.E,Row.FOUR);
    public static Pair<Column,Row> E5 = new Pair<>(Column.E,Row.FIVE);
    public static Pair<Column,Row> E6 = new Pair<>(Column.E,Row.SIX);
    public static Pair<Column,Row> E7 = new Pair<>(Column.E,Row.SEVEN);
    public static Pair<Column,Row> E8 = new Pair<>(Column.E,Row.EIGHT);

    public static Pair<Column,Row> F1 = new Pair<>(Column.F,Row.ONE);
    public static Pair<Column,Row> F2 = new Pair<>(Column.F,Row.TWO);
    public static Pair<Column,Row> F3 = new Pair<>(Column.F,Row.THREE);
    public static Pair<Column,Row> F4 = new Pair<>(Column.F,Row.FOUR);
    public static Pair<Column,Row> F5 = new Pair<>(Column.F,Row.FIVE);
    public static Pair<Column,Row> F6 = new Pair<>(Column.F,Row.SIX);
    public static Pair<Column,Row> F7 = new Pair<>(Column.F,Row.SEVEN);
    public static Pair<Column,Row> F8 = new Pair<>(Column.F,Row.EIGHT);

    public static Pair<Column,Row> G1 = new Pair<>(Column.G,Row.ONE);
    public static Pair<Column,Row> G2 = new Pair<>(Column.G,Row.TWO);
    public static Pair<Column,Row> G3 = new Pair<>(Column.G,Row.THREE);
    public static Pair<Column,Row> G4 = new Pair<>(Column.G,Row.FOUR);
    public static Pair<Column,Row> G5 = new Pair<>(Column.G,Row.FIVE);
    public static Pair<Column,Row> G6 = new Pair<>(Column.G,Row.SIX);
    public static Pair<Column,Row> G7 = new Pair<>(Column.G,Row.SEVEN);
    public static Pair<Column,Row> G8 = new Pair<>(Column.G,Row.EIGHT);

    public static Pair<Column,Row> H1 = new Pair<>(Column.H,Row.ONE);
    public static Pair<Column,Row> H2 = new Pair<>(Column.H,Row.TWO);
    public static Pair<Column,Row> H3 = new Pair<>(Column.H,Row.THREE);
    public static Pair<Column,Row> H4 = new Pair<>(Column.H,Row.FOUR);
    public static Pair<Column,Row> H5 = new Pair<>(Column.H,Row.FIVE);
    public static Pair<Column,Row> H6 = new Pair<>(Column.H,Row.SIX);
    public static Pair<Column,Row> H7 = new Pair<>(Column.H,Row.SEVEN);
    public static Pair<Column,Row> H8 = new Pair<>(Column.H,Row.EIGHT);

    private Row row;
    private Column column;

    public Coordinates(Row row, Column column) {
        this.row = row;
        this.column = column;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }
}
