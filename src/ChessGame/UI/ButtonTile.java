package ChessGame.UI;

import ChessGame.Logic.Pieces.Piece;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class ButtonTile extends Button {

    private Piece piece;

    public ButtonTile() {
        super();
        this.piece = null;
    }

    public ButtonTile(String text) {
        super(text);
        this.piece = null;
    }

    public ButtonTile(String text, Node graphic) {
        super(text, graphic);
        this.piece = null;
    }
}
