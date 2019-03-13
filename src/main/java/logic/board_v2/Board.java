package logic.board_v2;

public class Board {

    static char[][] board = {
            {'r', 'k', 'b', 'q', 'a', 'b', 'k', 'r'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
            {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'}
    };


    //region Constants

    public static final int numberOfTiles = 64;

    public static final int numberOfRows_Columns = 8;

    public static final int RIGHT = 1;

    public static final int LEFT = -1;

    public static final int UP = 1;

    public static final int DOWN = -1;

    public static final int FORWARD = 1;

    public static final int BACKWARD = -1;

    //endregion Constants

    //todo initialise this squares
    public static int blackKingPosition;

    public static int whiteKingPosition;

    public static String getPossibleMoves() {
        String list = "";
        for (int i = 0; i < numberOfTiles; i++) {
            switch (board[i / 8][i % 8]) {
                case 'P':
                    break;
                case 'p':
                    break;
                case 'k':
                    break;
                case 'K':
                    break;
                case 'B':
                    break;
                case 'b':
                    break;
                case 'R':
                    break;
                case 'r':
                    break;
                case 'Q':
                    break;
                case 'q':
                    break;
                case 'A':
                    break;
                case 'a':
                    break;

            }
        }
        return "";
    }

    public static String CalculateForPawn(int locationIndex) {
        //todo finish pawn
        return null;
    }

    public static String CalculateForKnight(int locationIndex) {
        StringBuilder output = new StringBuilder();
        char oldPiece;
        int row = locationIndex / numberOfRows_Columns;
        int col = locationIndex % numberOfRows_Columns;
        for (int i = LEFT; i <= RIGHT; i += 2) {
            for (int j = DOWN; j <= UP; j += 2) {
                try {
                    if (Character.isLowerCase(board[row + i][col + j * 2]) || ' ' == board[row + i][col + j * 2]) {
                        //if there is a black piece or it's a blank tile
                        oldPiece = board[row + i][col + j * 2];
                        board[row + i][col + j * 2] = 'K';
                        if (kingSafe()) {
                            output.append(row).append(col).append(row + i).append(col + j * 2).append(oldPiece);
                        }
                        board[row][col] = 'K';
                        board[row + i][col + j * 2] = oldPiece;
                    }
                } catch (Exception ignored) {

                }
                try {
                    if (Character.isLowerCase(board[row + i * 2][col + j]) || ' ' == board[row + i * 2][col + j]) {
                        //if there is a black piece or it's a blank tile
                        oldPiece = board[row + i * 2][col + j];
                        board[row + i * 2][col + j] = 'K';
                        if (kingSafe()) {
                            output.append(row).append(col).append(row + i * 2).append(col + j).append(oldPiece);
                        }
                        board[row][col] = 'K';
                        board[row + i * 2][col + j] = oldPiece;
                    }

                } catch (Exception ignored) {

                }
            }
        }
        return output.toString();
    }

    public static String CalculateForBishop(int locationIndex) {
        StringBuilder output = new StringBuilder();
        char oldPiece;
        int row = locationIndex / numberOfRows_Columns;
        int col = locationIndex % numberOfRows_Columns;
        int offset = 1;
        for (int i = LEFT; i <= RIGHT; i += 2) {
            for (int j = DOWN; j <= UP; j += 2) {
                try {
                    while (' ' == (board[row + offset * i][col + offset * j])) {
                        oldPiece = board[row + offset * i][col + offset * j];
                        board[row][col] = ' ';
                        board[row + offset * i][col + offset * j] = 'B';
                        if (kingSafe()) {
                            output.append(row).append(col).append(row + offset * i).append(col + offset * j).append(oldPiece);
                        }
                        board[row][col] = 'B';
                        board[row + offset * i][col + offset * j] = oldPiece;
                        offset++;
                    }
                    if (Character.isLowerCase(board[row + offset * i][col + offset * j])) {
                        oldPiece = board[row + offset * i][col + offset * j];
                        board[row][col] = ' ';
                        board[row + offset * i][col + offset * j] = 'B';
                        if (kingSafe()) {
                            output.append(row).append(col).append(row + offset * i).append(col + offset * j).append(oldPiece);
                        }
                        board[row][col] = 'B';
                        board[row + offset * i][col + offset * j] = oldPiece;
                    }
                } catch (Exception e) {
                }
                offset = 1;
            }
        }
        return output.toString();
    }

    public static String CalculateForRook(int locationIndex) {

        StringBuilder output = new StringBuilder();
        char oldPiece;
        int row = locationIndex / numberOfRows_Columns;
        int col = locationIndex % numberOfRows_Columns;
        int offset = 1;
        for (int j = BACKWARD; j <= FORWARD; j += 2) {
            try {
                while (' ' == (board[row][col + offset * j])) {
                    oldPiece = board[row][col + offset * j];
                    board[row][col] = ' ';
                    board[row][col + offset * j] = 'R';
                    if (kingSafe()) {
                        output.append(row).append(col).append(row).append(col + offset * j).append(oldPiece);
                    }
                    board[row][col] = 'R';
                    board[row][col + offset * j] = oldPiece;
                    offset++;
                }
                if (Character.isLowerCase(board[row][col + offset * j])) {
                    //if there is a black piece on the last square --> add it as a valid move
                    oldPiece = board[row][col + offset * j];
                    board[row][col] = ' ';
                    board[row][col + offset * j] = 'R';
                    if (kingSafe()) {
                        output.append(row).append(col).append(row).append(col + offset * j).append(oldPiece);
                    }
                    board[row][col] = 'R';
                    board[row][col + offset * j] = oldPiece;
                }
            } catch (Exception e) {
            }
            offset = 1;
            try {
                while (' ' == (board[row + offset * j][col])) {
                    oldPiece = board[row + offset * j][col];
                    board[row][col] = ' ';
                    board[row + offset * j][col] = 'R';
                    if (kingSafe()) {
                        output.append(row).append(col).append(row + offset * j).append(col).append(oldPiece);
                    }
                    board[row][col] = 'R';
                    board[row + offset * j][col] = oldPiece;
                    offset++;
                }
                if (Character.isLowerCase(board[row + offset * j][col])) {
                    oldPiece = board[row + offset * j][col];
                    board[row][col] = ' ';
                    board[row + offset * j][col] = 'R';
                    if (kingSafe()) {
                        output.append(row).append(col).append(row + offset * j).append(col).append(oldPiece);
                    }
                    board[row][col] = 'R';
                    board[row + offset * j][col] = oldPiece;
                }
            } catch (Exception e) {
            }
            offset = 1;
        }
        return output.toString();
    }


    public static String CalculateForQueen(int locationIndex) {
        StringBuilder output = new StringBuilder();
        char oldPiece;
        int row = locationIndex = locationIndex / numberOfRows_Columns;
        int col = locationIndex % numberOfRows_Columns;
        int offset = 1;

        for (int i = DOWN; i <= UP; i++) {
            for (int j = LEFT; j <= RIGHT; j++) {
                try {
                    while (board[row + offset * i][col + offset * j] == ' ') {
                        //as long as there is a place to go - move the queen over there
                        checkCurrentMoveQ(output, row, col, offset, i, j);
                        offset++;
                    }
                    if (Character.isLowerCase((board[row + offset * i][col + offset * j]))) {
                        //if the last move there was an enemy piece --> add the last move
                        checkCurrentMoveQ(output, row, col, offset, i, j);

                    }
                } catch (Exception ignored) {

                }
                offset = 1;
            }

        }


        return output.toString();
    }

    private static void checkCurrentMoveQ(StringBuilder output, int row, int col, int offset, int verticalIndex, int horizontalIndex) {
        char oldPiece;
        oldPiece = board[row + offset * verticalIndex][col + offset * horizontalIndex];
        board[row][col] = ' ';
        board[row + offset * verticalIndex][col + offset * horizontalIndex] = 'Q';
        if (kingSafe()) {
            //if it's a valid move - add to the out put list
            output.append(row).append(col).append(row + offset * verticalIndex).append(col + offset * horizontalIndex).append(oldPiece);
        }
        //reversing back
        board[row][col] = 'Q';
        board[row + offset * verticalIndex][col + offset * horizontalIndex] = oldPiece;
    }

    public static String CalculateForKing(int locationIndex) {
        StringBuilder output = new StringBuilder();
        char oldPiece;
        int row = locationIndex / numberOfRows_Columns;
        int col = locationIndex % numberOfRows_Columns;
        for (int i = 0; i < 9; i++) {
            if (i != 4) {
                try {
                    char possibleTarget = board[row - 1 + i / 3][col - 1 + i % 3];
                    //as long it's not the place where the king is currently is
                    if ((Character.isLowerCase(possibleTarget)) || (' ' == possibleTarget)) {
                        //if there is enemy there, or if it's a blank spot
                        oldPiece = possibleTarget;
                        board[row][col] = ' ';
                        board[row - 1 + i / 3][col - 1 + i % 3] = 'A';
                        int kingOldPosition = whiteKingPosition;
                        whiteKingPosition = locationIndex + (i / 3) * 8 + (i % 3) - 9;
                        if (kingSafe()) {
                            //if the move is valid - add to output
                            //todo maybe to add an regex
                            output.append(row).append(col).append(row - 1 + i / 3).append(col - 1 + i % 3).append(oldPiece);
                        }
                        board[row][col] = 'A';
                        board[row - 1 + i / 3][col - 1 + i % 3] = oldPiece;
                        whiteKingPosition = kingOldPosition;

                    }
                } catch (Exception ignored) {

                }
            }
        }
        //todo add castling
        return output.toString();
    }

    public static boolean kingSafe() {
        //checking enemy bishops and queen diagonals
        int offset = 1;
        for (int i = LEFT; i <= RIGHT; i += 2) {
            for (int j = DOWN; j <= UP; j += 2) {
                try {
                    while (' ' == (board[whiteKingPosition / numberOfRows_Columns + offset * i][whiteKingPosition % numberOfRows_Columns + offset * j])) {
                        offset++;
                    }
                    if ('b' == (board[whiteKingPosition / numberOfRows_Columns + offset * i][whiteKingPosition % numberOfRows_Columns + offset * j]) ||
                            'q' == (board[whiteKingPosition / numberOfRows_Columns + offset * i][whiteKingPosition % numberOfRows_Columns + offset * j])) {

                        return false;
                    }

                } catch (Exception ignored) {
                }
                offset = 1;
            }
        }
        //checking rooks and queens leftover
        offset = 1;
        for (int i = BACKWARD; i <= FORWARD; i += 2) {
            try {
                while (' ' == (board[whiteKingPosition / numberOfRows_Columns][whiteKingPosition % numberOfRows_Columns + offset * i])) {
                    offset++;
                }
                if ('r' == (board[whiteKingPosition / numberOfRows_Columns][whiteKingPosition % numberOfRows_Columns + offset * i]) ||
                        'q' == (board[whiteKingPosition / numberOfRows_Columns][whiteKingPosition % numberOfRows_Columns + offset * i])) {

                    return false;
                }

            } catch (Exception ignored) {
            }
            offset = 1;
            try {
                while (' ' == (board[whiteKingPosition / numberOfRows_Columns + offset * i][whiteKingPosition % numberOfRows_Columns])) {
                    offset++;
                }
                if ('r' == (board[whiteKingPosition / numberOfRows_Columns + offset * i][whiteKingPosition % numberOfRows_Columns]) ||
                        'q' == (board[whiteKingPosition / numberOfRows_Columns + offset * i][whiteKingPosition % numberOfRows_Columns])) {

                    return false;
                }

            } catch (Exception ignored) {
            }
            offset = 1;
        }
        //checking for enemy knight
        for (int i = LEFT; i <= RIGHT; i += 2) {
            for (int j = DOWN; j <= UP; j += 2) {
                try {
                    if ('k' == (board[whiteKingPosition / numberOfRows_Columns + i][whiteKingPosition % numberOfRows_Columns + j * 2])) {

                        return false;
                    }

                } catch (Exception ignored) {
                }
                try {
                    if ('k' == (board[whiteKingPosition / numberOfRows_Columns + i * 2][whiteKingPosition % numberOfRows_Columns + j])) {

                        return false;
                    }

                } catch (Exception ignored) {
                }
                offset = 1;
            }
        }
        //checking for enemy pawns
        if(whiteKingPosition >= 16){
            //as long as the king is in a row that a pawn can appear in
            try {
                if ('p' == (board[whiteKingPosition / numberOfRows_Columns -1][whiteKingPosition % numberOfRows_Columns -1])) {
                    return false;
                }

            } catch (Exception ignored) {
            }

            try {
                if ('p' == (board[whiteKingPosition / numberOfRows_Columns -1][whiteKingPosition % numberOfRows_Columns +1])) {
                    return false;
                }

            } catch (Exception ignored) {
            }
        }

        //checking for enemy king
        for (int i = LEFT; i <= RIGHT; i ++) {
            for (int j = DOWN; j <= UP; j ++) {
                if(i!=0 || j!=0){
                    try {
                        if ('a' == (board[whiteKingPosition / numberOfRows_Columns + i][whiteKingPosition % numberOfRows_Columns + j])) {
                            return false;
                        }

                    } catch (Exception ignored) {
                    }
                }
            }
        }
        return true;
    }
}
