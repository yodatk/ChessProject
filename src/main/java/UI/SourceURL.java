package UI;

/**
 * enum represent the all game images URL with there scores , of the image has no score we will put 0.
 */
public enum SourceURL {


    //region Tiles Images
    DARK_TILE(0){
        public String toString() {
            return "Images/brownMarbleTIle.jpg";
        }
    },

    LIGHT_TILE(0){
        public String toString() {
            return "Images/whiteMarvelTile.jpg";
        }
    },
    TARGET(0){
        public String toString() {
            return "Images/target.jpg";
        }
    },

    GAME_ICON(0){
        public String toString() {
            return "Images/Chess-Game-grey.png";
        }
    },

    LIGHT_PAWN(0){
        public String toString() {
            return "Images/northPieces/white_pawn.png";
        }
    },
    LIGHT_KNIGHT(0){
        public String toString() {
            return "Images/northPieces/white_knight.png";
        }
    },
    LIGHT_ROOK(0){
        public String toString() {
            return "Images/northPieces/white_rook.png";
        }
    },
    LIGHT_BISHOP(0){
        public String toString() {
            return "Images/northPieces/white_bishop.png";
        }
    },
    LIGHT_KING(0){
        public String toString() {
            return "Images/northPieces/white_king.png";
        }
    },
    LIGHT_QUEEN(0) {
        public String toString () {
            return "Images/northPieces/white_queen.png";
        }
    },

    DARK_PAWN(0){
        public String toString() {
            return "Images/northPieces/black_pawn.png";
        }
    },
    DARK_KNIGHT(0){
        public String toString() {
            return "Images/northPieces/black_knight.png";
        }
    },
    DARK_ROOK(0){
        public String toString() {
            return "Images/northPieces/black_rook.png";
        }
    },
    DARK_BISHOP(0){
        public String toString() {
            return "Images/northPieces/black_bishop.png";
        }
    },
    DARK_KING(0){
        public String toString() {
            return "Images/northPieces/black_king.png";
        }
    },
    DARK_QUEEN(0) {
        public String toString () {
            return "Images/northPieces/black_queen.png";
        }
    };


    //endregion Tiles Images


    private final int score;
    private SourceURL(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

}


