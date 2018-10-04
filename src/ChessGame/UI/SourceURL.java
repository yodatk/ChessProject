package ChessGame.UI;

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

