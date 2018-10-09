package ChessGame.Logic;

import java.util.*;

public class Coordinate {

    public static Coordinate A1 = new Coordinate(Column.A, Row.ONE);
    public static Coordinate A2 = new Coordinate(Column.A, Row.TWO);
    public static Coordinate A3 = new Coordinate(Column.A, Row.THREE);
    public static Coordinate A4 = new Coordinate(Column.A, Row.FOUR);
    public static Coordinate A5 = new Coordinate(Column.A, Row.FIVE);
    public static Coordinate A6 = new Coordinate(Column.A, Row.SIX);
    public static Coordinate A7 = new Coordinate(Column.A, Row.SEVEN);
    public static Coordinate A8 = new Coordinate(Column.A, Row.EIGHT);

    public static Coordinate B1 = new Coordinate(Column.B, Row.ONE);
    public static Coordinate B2 = new Coordinate(Column.B, Row.TWO);
    public static Coordinate B3 = new Coordinate(Column.B, Row.THREE);
    public static Coordinate B4 = new Coordinate(Column.B, Row.FOUR);
    public static Coordinate B5 = new Coordinate(Column.B, Row.FIVE);
    public static Coordinate B6 = new Coordinate(Column.B, Row.SIX);
    public static Coordinate B7 = new Coordinate(Column.B, Row.SEVEN);
    public static Coordinate B8 = new Coordinate(Column.B, Row.EIGHT);

    public static Coordinate C1 = new Coordinate(Column.C, Row.ONE);
    public static Coordinate C2 = new Coordinate(Column.C, Row.TWO);
    public static Coordinate C3 = new Coordinate(Column.C, Row.THREE);
    public static Coordinate C4 = new Coordinate(Column.C, Row.FOUR);
    public static Coordinate C5 = new Coordinate(Column.C, Row.FIVE);
    public static Coordinate C6 = new Coordinate(Column.C, Row.SIX);
    public static Coordinate C7 = new Coordinate(Column.C, Row.SEVEN);
    public static Coordinate C8 = new Coordinate(Column.C, Row.EIGHT);

    public static Coordinate D1 = new Coordinate(Column.D, Row.ONE);
    public static Coordinate D2 = new Coordinate(Column.D, Row.TWO);
    public static Coordinate D3 = new Coordinate(Column.D, Row.THREE);
    public static Coordinate D4 = new Coordinate(Column.D, Row.FOUR);
    public static Coordinate D5 = new Coordinate(Column.D, Row.FIVE);
    public static Coordinate D6 = new Coordinate(Column.D, Row.SIX);
    public static Coordinate D7 = new Coordinate(Column.D, Row.SEVEN);
    public static Coordinate D8 = new Coordinate(Column.D, Row.EIGHT);

    public static Coordinate E1 = new Coordinate(Column.E, Row.ONE);
    public static Coordinate E2 = new Coordinate(Column.E, Row.TWO);
    public static Coordinate E3 = new Coordinate(Column.E, Row.THREE);
    public static Coordinate E4 = new Coordinate(Column.E, Row.FOUR);
    public static Coordinate E5 = new Coordinate(Column.E, Row.FIVE);
    public static Coordinate E6 = new Coordinate(Column.E, Row.SIX);
    public static Coordinate E7 = new Coordinate(Column.E, Row.SEVEN);
    public static Coordinate E8 = new Coordinate(Column.E, Row.EIGHT);

    public static Coordinate F1 = new Coordinate(Column.F, Row.ONE);
    public static Coordinate F2 = new Coordinate(Column.F, Row.TWO);
    public static Coordinate F3 = new Coordinate(Column.F, Row.THREE);
    public static Coordinate F4 = new Coordinate(Column.F, Row.FOUR);
    public static Coordinate F5 = new Coordinate(Column.F, Row.FIVE);
    public static Coordinate F6 = new Coordinate(Column.F, Row.SIX);
    public static Coordinate F7 = new Coordinate(Column.F, Row.SEVEN);
    public static Coordinate F8 = new Coordinate(Column.F, Row.EIGHT);

    public static Coordinate G1 = new Coordinate(Column.G, Row.ONE);
    public static Coordinate G2 = new Coordinate(Column.G, Row.TWO);
    public static Coordinate G3 = new Coordinate(Column.G, Row.THREE);
    public static Coordinate G4 = new Coordinate(Column.G, Row.FOUR);
    public static Coordinate G5 = new Coordinate(Column.G, Row.FIVE);
    public static Coordinate G6 = new Coordinate(Column.G, Row.SIX);
    public static Coordinate G7 = new Coordinate(Column.G, Row.SEVEN);
    public static Coordinate G8 = new Coordinate(Column.G, Row.EIGHT);

    public static Coordinate H1 = new Coordinate(Column.H, Row.ONE);
    public static Coordinate H2 = new Coordinate(Column.H, Row.TWO);
    public static Coordinate H3 = new Coordinate(Column.H, Row.THREE);
    public static Coordinate H4 = new Coordinate(Column.H, Row.FOUR);
    public static Coordinate H5 = new Coordinate(Column.H, Row.FIVE);
    public static Coordinate H6 = new Coordinate(Column.H, Row.SIX);
    public static Coordinate H7 = new Coordinate(Column.H, Row.SEVEN);
    public static Coordinate H8 = new Coordinate(Column.H, Row.EIGHT);

    public static Map<String,Coordinate> allCoordinates;

    static {
        // === A COLUMN
        //A1
        setSurround(A1, A2, null, B2, null, null, null, null, B1);
        //A2
        setSurround(A2, A3, null, B3, A1, null, B1, null, B2);
        //A3
        setSurround(A3, A4, null, B4, A2, null, B2, null, B3);
        //A4
        setSurround(A4, A5, null, B5, A3, null, B3, null, B4);
        //A5
        setSurround(A5, A6, null, B6, A4, null, B4, null, B5);
        //A6
        setSurround(A6, A7, null, B7, A5, null, B5, null, B6);
        //A7
        setSurround(A7, A8, null, B8, A6, null, B6, null, B7);
        //A8
        setSurround(A8, null, null, null, A7, null, B7, null, B8);

        // === B COLUMN
        //B1
        setSurround(B1, B2, A2, C2, null, null, null, A1, C1);
        //B2
        setSurround(B2, B3, A3, C3, B1, A1, C1, A2, C2);
        //B3
        setSurround(B3, B4, A4, C4, B2, A2, C2, A3, C3);
        //B4
        setSurround(B4, B5, A5, C5, B3, A3, C3, A4, C4);
        //B5
        setSurround(B5, B6, A6, C6, B4, A4, C4, A5, C5);
        //B6
        setSurround(B6, B7, A7, C7, B5, A5, C5, A6, C6);
        //B7
        setSurround(B7, B8, A8, C8, B6, A5, C6, A7, C7);
        //B8
        setSurround(B8, null, null, null, B7, A7, C7, A8, C8);

        // === C COLUMN
        //C1
        setSurround(C1, C2, B2, D2, null, null, null, B1, D1);
        //C2
        setSurround(C2, C3, B3, D3, C1, B1, D1, B2, D2);
        //C3
        setSurround(C3, C4, B4, D4, C2, B2, D2, B3, D3);
        //C4
        setSurround(C4, C5, B5, D5, C3, B3, D3, B4, D4);
        //C5
        setSurround(C5, C6, B6, D6, C4, B4, D4, B5, D5);
        //C6
        setSurround(C6, C7, B7, D7, C5, B5, D5, B6, D6);
        //C7
        setSurround(C7, C8, B8, D8, C6, B5, D6, B7, D7);
        //C8
        setSurround(C8, null, null, null, C7, B7, D7, B8, D8);

        // === D COLUMN
        //D1
        setSurround(D1, D2, C2, E2, null, null, null, C1, E1);
        //D2
        setSurround(D2, D3, C3, E3, D1, C1, E1, C2, E2);
        //D3
        setSurround(D3, D4, C4, E4, D2, C2, E2, C3, E3);
        //D4
        setSurround(D4, D5, C5, E5, D3, C3, E3, C4, E4);
        //D5
        setSurround(D5, D6, C6, E6, D4, C4, E4, C5, E5);
        //D6
        setSurround(D6, D7, C7, E7, D5, C5, E5, C6, E6);
        //D7
        setSurround(D7, D8, C8, E8, D6, C5, E6, C7, E7);
        //D8
        setSurround(D8, null, null, null, D7, C7, E7, C8, E8);

        // === E COLUMN
        //E1
        setSurround(E1, E2, D2, F2, null, null, null, D1, F1);
        //E2
        setSurround(E2, E3, D3, F3, E1, D1, F1, D2, F2);
        //E3
        setSurround(E3, E4, D4, F4, E2, D2, F2, D3, F3);
        //E4
        setSurround(E4, E5, D5, F5, E3, D3, F3, D4, F4);
        //E5
        setSurround(E5, E6, D6, F6, E4, D4, F4, D5, F5);
        //E6
        setSurround(E6, E7, D7, F7, E5, D5, F5, D6, F6);
        //E7
        setSurround(E7, E8, D8, F8, E6, D6, F6, D7, F7);
        //E8
        setSurround(E8, null, null, null, E7, D7, F7, D8, F8);

        // === F COLUMN
        //F1
        setSurround(F1, F2, E2, G2, null, null, null, E1, G1);
        //F2
        setSurround(F2, F3, E3, G3, F1, E1, G1, E2, G2);
        //F3
        setSurround(F3, F4, E4, G4, F2, E2, G2, E3, G3);
        //F4
        setSurround(F4, F5, E5, G5, F3, E3, G3, E4, G4);
        //F5
        setSurround(F5, F6, E6, G6, F4, E4, G4, E5, G5);
        //F6
        setSurround(F6, F7, E7, G7, F5, E5, G5, E6, G6);
        //F7
        setSurround(F7, F8, E8, G8, F6, E5, G6, E7, G7);
        //F8
        setSurround(F8, null, null, null, F7, E7, G7, E8, G8);

        // === G COLUMN
        //G1
        setSurround(G1, G2, F2, H2, null, null, null, F1, H1);
        //G2
        setSurround(G2, G3, F3, H3, G1, F1, H1, F2, H2);
        //G3
        setSurround(G3, G4, F4, H4, G2, F2, H2, F3, H3);
        //G4
        setSurround(G4, G5, F5, H5, G3, F3, H3, F4, H4);
        //G5
        setSurround(G5, G6, F6, H6, G4, F4, H4, F5, H5);
        //G6
        setSurround(G6, G7, F7, H7, G5, F5, H5, F6, H6);
        //G7
        setSurround(G7, G8, F8, H8, G6, F5, H6, F7, H7);
        //G8
        setSurround(G8, null, null, null, G7, F7, H7, F8, H8);

        // === H COLUMN

        //H1
        setSurround(H1, H2, G2, null, null, null, null, G1, null);
        //H2
        setSurround(H2, H3, G3, null, H1, G1, null, G2, null);
        //H3
        setSurround(H3, H4, G4, null, H2, G2, null, G3, null);
        //H4
        setSurround(H4, H5, G5, null, H3, G3, null, G4, null);
        //H5
        setSurround(H5, H6, G6, null, H4, G4, null, G5, null);
        //H6
        setSurround(H6, H7, G7, null, H5, G5, null, G6, null);
        //H7
        setSurround(H7, H8, G8, null, H6, G5, null, G7, null);
        //H8
        setSurround(H8, null, null, null, H7, G7, null, G8, null);

        allCoordinates = new HashMap<String, Coordinate>();
        allCoordinates.put("7,0",A1);allCoordinates.put("6,0",A2);allCoordinates.put("5,0",A3);allCoordinates.put("4,0",A4);allCoordinates.put("3,0",A5);allCoordinates.put("2,0",A6);allCoordinates.put("1,0",A7);allCoordinates.put("0,0",A8);
        allCoordinates.put("7,1",B1);allCoordinates.put("6,1",B2);allCoordinates.put("5,1",B3);allCoordinates.put("4,1",B4);allCoordinates.put("3,1",B5);allCoordinates.put("2,1",B6);allCoordinates.put("1,1",B7);allCoordinates.put("0,1",B8);
        allCoordinates.put("7,2",C1);allCoordinates.put("6,2",C2);allCoordinates.put("5,2",C3);allCoordinates.put("4,2",C4);allCoordinates.put("3,2",C5);allCoordinates.put("2,2",C6);allCoordinates.put("1,2",C7);allCoordinates.put("0,2",C8);
        allCoordinates.put("7,3",D1);allCoordinates.put("6,3",D2);allCoordinates.put("5,3",D3);allCoordinates.put("4,3",D4);allCoordinates.put("3,3",D5);allCoordinates.put("2,3",D6);allCoordinates.put("1,3",D7);allCoordinates.put("0,3",D8);
        allCoordinates.put("7,4",E1);allCoordinates.put("6,4",E2);allCoordinates.put("5,4",E3);allCoordinates.put("4,4",E4);allCoordinates.put("3,4",E5);allCoordinates.put("2,4",E6);allCoordinates.put("1,4",E7);allCoordinates.put("0,4",E8);
        allCoordinates.put("7,5",F1);allCoordinates.put("6,5",F2);allCoordinates.put("5,5",F3);allCoordinates.put("4,5",F4);allCoordinates.put("3,5",F5);allCoordinates.put("2,5",F6);allCoordinates.put("1,5",F7);allCoordinates.put("0,5",F8);
        allCoordinates.put("7,6",G1);allCoordinates.put("6,6",G2);allCoordinates.put("5,6",G3);allCoordinates.put("4,6",G4);allCoordinates.put("3,6",G5);allCoordinates.put("2,6",G6);allCoordinates.put("1,6",G7);allCoordinates.put("0,6",G8);
        allCoordinates.put("7,7",H1);allCoordinates.put("6,7",H2);allCoordinates.put("5,7",H3);allCoordinates.put("4,7",H4);allCoordinates.put("3,7",H5);allCoordinates.put("2,7",H6);allCoordinates.put("1,7",H7);allCoordinates.put("0,7",H8);

        //inserting all coordinates to the list
        /*allCoordinates = new HashSet<>(Arrays.asList(
                A1, A2, A3, A4, A5, A6, A7, A8,
                B1, B2, B3, B4, B5, B6, B7, B8,
                C1, C2, C3, C4, C5, C6, C7, C8,
                D1, D2, D3, D4, D5, D6, D7, D8,
                E1, E2, E3, E4, E5, E6, E7, E8,
                F1, F2, F3, F4, F5, F6, F7, F8,
                G1, G2, G3, G4, G5, G6, G7, G8,
                H1, H2, H3, H4, H5, H6, H7, H8

        ));*/

    }

    private static void setSurround(Coordinate toSet, Coordinate north, Coordinate north_west, Coordinate north_east,
                                    Coordinate south, Coordinate south_west, Coordinate south_east,
                                    Coordinate west, Coordinate east) {
        toSet.north = north;
        toSet.north_east = north_east;
        toSet.north_west = north_west;
        toSet.south = south;
        toSet.south_east = south_east;
        toSet.south_west = south_west;
        toSet.east = east;
        toSet.west = west;

    }

    private Row row;
    private Column column;

    private Coordinate north;
    private Coordinate north_east;
    private Coordinate north_west;

    private Coordinate south;
    private Coordinate south_east;
    private Coordinate south_west;

    private Coordinate east;

    private Coordinate west;

    public Coordinate(Column column, Row row) {
        this.row = row;
        this.column = column;
        this.north = null;
        this.north_east = null;
        this.north_west = null;
        this.south = null;
        this.south_east = null;
        this.south_west = null;
        this.east = null;
        this.west = null;

    }

    public Row getRow() {
        return row;
    }

    public Column getColumn() {
        return column;
    }


    public void setRow(Row row) {
        this.row = row;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    public Coordinate getNorth() {
        return north;
    }

    public Coordinate getNorth_east() {
        return north_east;
    }

    public Coordinate getNorth_west() {
        return north_west;
    }

    public Coordinate getSouth() {
        return south;
    }

    public Coordinate getSouth_east() {
        return south_east;
    }

    public Coordinate getSouth_west() {
        return south_west;
    }

    public Coordinate getEast() {
        return east;
    }

    public Coordinate getWest() {
        return west;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        Coordinate other = (Coordinate) obj;
        return this.column.equals(other.column) && this.row.equals(other.row);
    }

    @Override
    public String toString() {
        return this.column.toString() + this.row.toString();
    }

}
