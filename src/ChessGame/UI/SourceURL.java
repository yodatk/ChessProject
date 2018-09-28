package ChessGame.UI;

/**
 * enum represent the all game images URL with there scores , of the image has no score we will put 0.
 */
public enum SourceURL {

    //region Titles And Covers
    ANIMATED_PACMAN(0){
        public String toString() {
            return "img/Little_Icons/NicePacman/down/pac32_down.png";
        }
    },
    PACMAN_GIF(0){
        public String toString() {
            return "img/titlesAndCovers/PacmanGif.gif";
        }
    },
    START_PAGE_TITLE(0){
        public String toString() {
            return "img/titlesAndCovers/title.png";
        }
    },
    GAME_OVER(0){
        public String toString() {
            return "img/titlesAndCovers/game_over.gif";
        }
    },
    BOARD_WON(0){
        public String toString() {
            return "img/titlesAndCovers/youWon.gif";
        }
    },

    YOU_LOSE(0){
        public String toString() {
            return "img/titlesAndCovers/youLose.png";
        }
    },
    YOU_WON(0){
        public String toString() {
            return "img/titlesAndCovers/WinningBackground.jpeg";
        }
    },

    //endregion Titles And Covers

    //region NicePacman

    //region Right Yellow NicePacman Animation
    NICE_RIGHT (0){
        public String toString() {
            return "img/Little_Icons/NicePacman/right/pac32_right.png";
        }
    },

    NICE_RIGHT_WIDE(0) {
        public String toString() {
            return "img/Little_Icons/NicePacman/right/pac32_right_wide.png";
        }
    },
    NICE_RIGHT_WIDEST(0) {
        public String toString() {
            return "img/Little_Icons/NicePacman/right/pac32_right_widest.png";
        }
    },
    NICE_RIGHT_CLOSE(0) {
        public String toString() {
            return "img/Little_Icons/NicePacman/right/pacman_closed_right.png";
        }
    },
    //endregion Right Yellow NicePacman Animation

    //region  Left Yellow NicePacman Animation

    NICE_LEFT(0) {
        public String toString() {
            return "img/Little_Icons/NicePacman/left/pac32_left.png";
        }
    },

    NICE_LEFT_WIDE (0){
        public String toString() {
            return "img/Little_Icons/NicePacman/left/pac32_left_wide.png";
        }
    },
    NICE_LEFT_WIDEST(0) {
        public String toString() {
            return "img/Little_Icons/NicePacman/left/pac32_left_widest.png";
        }
    },
    NICE_LEFT_CLOSE(0) {
        public String toString() {
            return "img/Little_Icons/NicePacman/left/pacman_closed_left.png";
        }
    },

    //endregion Left Yellow NicePacman Animation

    //region Up Yellow NicePacman Animation

    NICE_UP (0){
        public String toString() {
            return "img/Little_Icons/NicePacman/up/pac32_up.png";
        }
    },

    NICE_UP_WIDE(0) {
        public String toString() {
            return "img/Little_Icons/NicePacman/up/pac32_up_wide.png";
        }
    },
    NICE_UP_WIDEST (0){
        public String toString() {
            return "img/Little_Icons/NicePacman/up/pac32_up_widest.png";
        }
    },
    NICE_UP_CLOSE(0) {
        public String toString() {
            return "img/Little_Icons/NicePacman/up/pacman_closed_up.png";
        }
    },

    //endregion Up Yellow NicePacman Animation

    //region Down Yellow NicePacman Animation

    NICE_DOWN(0) {
        public String toString() {
            return "img/Little_Icons/NicePacman/down/pac32_down.png";
        }
    },

    NICE_DOWN_WIDE (0){
        public String toString() {
            return "img/Little_Icons/NicePacman/down/pac32_down_wide.png";
        }
    },
    NICE_DOWN_WIDEST(0) {
        public String toString() {
            return "img/Little_Icons/NicePacman/down/pac32_down_widest.png";
        }
    },
    NICE_DOWN_CLOSE(0) {
        public String toString() {
            return "img/Little_Icons/NicePacman/down/pacman_closed_down.png";
        }
    },

    //endregion Down Yellow NicePacman Animation

    //endregion NicePacman

    //region Protected Pacman

    //region Right Blue Protected Pacman Animation
    PROTECTED_RIGHT(0) {
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/right/pac32_right.png";
        }
    },

    PROTECTED_RIGHT_WIDE(0) {
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/right/pac32_right_wide.png";
        }
    },
    PROTECTED_RIGHT_WIDEST (0){
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/right/pac32_right_widest.png";
        }
    },
    PROTECTED_RIGHT_CLOSE (0){
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/right/pacman_closed_right.png";
        }
    },
    //endregion Right Blue Protected Pacman Animation

    //region  Left Blue Protected Pacman Animation

    PROTECTED_LEFT(0) {
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/left/pac32_left.png";
        }
    },

    PROTECTED_LEFT_WIDE (0){
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/left/pac32_left_wide.png";
        }
    },
    PROTECTED_LEFT_WIDEST (0){
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/left/pac32_left_widest.png";
        }
    },
    PROTECTED_LEFT_CLOSE (0){
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/left/pacman_closed_left.png";
        }
    },

    //endregion Left Blue Protected Pacman Animation

    //region Up Blue Protected Pacman Animation

    PROTECTED_UP (0){
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/up/pac32_up.png";
        }
    },

    PROTECTED_UP_WIDE (0){
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/up/pac32_up_wide.png";
        }
    },
    PROTECTED_UP_WIDEST(0) {
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/up/pac32_up_widest.png";
        }
    },
    PROTECTED_UP_CLOSE (0){
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/up/pacman_closed_up.png";
        }
    },

    //endregion Up Blue Protected Pacman Animation

    //region Down Blue Protected Pacman Animation

    PROTECTED_DOWN (0){
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/down/pac32_down.png";
        }
    },

    PROTECTED_DOWN_WIDE (0){
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/down/pac32_down_wide.png";
        }
    },
    PROTECTED_DOWN_WIDEST(0) {
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/down/pac32_down_widest.png";
        }
    },
    PROTECTED_DOWN_CLOSE(0) {
        public String toString() {
            return "img/Little_Icons/ProtectedPacman/down/pacman_closed_down.png";
        }
    },

    //endregion Down Blue Protected Pacman Animation

    //endregion Protected Pacman

    //region Angry Pacman

    //region Right Red Angry Pacman Animation
    ANGRY_RIGHT (0){
        public String toString() {
            return "img/Little_Icons/AngryPacman/right/pac32_right.png";
        }
    },

    ANGRY_RIGHT_WIDE (0){
        public String toString() {
            return "img/Little_Icons/AngryPacman/right/pac32_right_wide.png";
        }
    },
    ANGRY_RIGHT_WIDEST(0) {
        public String toString() {
            return "img/Little_Icons/AngryPacman/right/pac32_right_widest.png";
        }
    },
    ANGRY_RIGHT_CLOSE(0) {
        public String toString() {
            return "img/Little_Icons/AngryPacman/right/pacman_closed_right.png";
        }
    },
    //endregion Right Red Angry Pacman Animation

    //region  Red Angry Pacman Animation

    ANGRY_LEFT(0) {
        public String toString() {
            return "img/Little_Icons/AngryPacman/left/pac32_left.png";
        }
    },

    ANGRY_LEFT_WIDE (0){
        public String toString() {
            return "img/Little_Icons/AngryPacman/left/pac32_left_wide.png";
        }
    },
    ANGRY_LEFT_WIDEST (0){
        public String toString() {
            return "img/Little_Icons/AngryPacman/left/pac32_left_widest.png";
        }
    },
    ANGRY_LEFT_CLOSE (0){
        public String toString() {
            return "img/Little_Icons/AngryPacman/left/pacman_closed_left.png";
        }
    },

    //endregion Left Red Angry Pacman Animation

    //region Up Red Angry Pacman Animation

    ANGRY_UP (0){
        public String toString() {
            return "img/Little_Icons/AngryPacman/up/pac32_up.png";
        }
    },

    ANGRY_UP_WIDE (0){
        public String toString() {
            return "img/Little_Icons/AngryPacman/up/pac32_up_wide.png";
        }
    },
    ANGRY_UP_WIDEST (0){
        public String toString() {
            return "img/Little_Icons/AngryPacman/up/pac32_up_widest.png";
        }
    },
    ANGRY_UP_CLOSE (0){
        public String toString() {
            return "img/Little_Icons/AngryPacman/up/pacman_closed_up.png";
        }
    },

    //endregion Up Red Angry Pacman Animation

    //region Down Red Angry Pacman Animation

    ANGRY_DOWN (0){
        public String toString() {
            return "img/Little_Icons/AngryPacman/down/pac32_down.png";
        }
    },

    ANGRY_DOWN_WIDE (0){
        public String toString() {
            return "img/Little_Icons/AngryPacman/down/pac32_down_wide.png";
        }
    },
    ANGRY_DOWN_WIDEST (0){
        public String toString() {
            return "img/Little_Icons/AngryPacman/down/pac32_down_widest.png";
        }
    },
    ANGRY_DOWN_CLOSE (0){
        public String toString() {
            return "img/Little_Icons/AngryPacman/down/pacman_closed_down.png";
        }
    },

    //endregion Down Red Angry Pacman Animation

    //endregion Angry Pacman

    //region Blocks

    REGULAR_BLOCK (0){
        public String toString() {
            return "img/MapBlocks/Block.jpg";
        }
    },

    CAGE_BLOCK (0){
        public String toString() {
            return "img/MapBlocks/CageBlock.png";
        }
    },

    BROWN_BLOCK(0){
        public String toString() {
            return "img/MapBlocks/brownBrick.png";
        }
    },
    YELLOW_BLOCK(0){
        public String toString() {
            return "img/MapBlocks/yellowBlock.png";
        }
    },
    WOOD_BLOCK(0){
        public String toString() {
            return "img/MapBlocks/parquetBlock.jpg";
        }
    },
    ICE_BLOCK(0){
        public String toString() {
            return "img/MapBlocks/iceBlock.png";
        }
    },

    //endregion Blocks

    //region Items

    HEALTH_PILL(50){
        public String toString(){
            return "img/Little_Icons/items/HealthPills.png";
        }
    },

    NORMAL_PILL(10){
        public String toString(){
            return "img/Little_Icons/items/NormaPill.png";
        }
    },


    STRAWBERRY(300){
        public String toString(){
            return "img/Little_Icons/items/strawberry.png";
        }
    },
    DIAMOND(250){
        public String toString(){
            return "img/Little_Icons/items/diamond.png";
        }
    },
    PINAPPLE(100){
        public String toString(){
            return "img/Little_Icons/items/pinapple.png";
        }
    },
    APPLE(200){
        public String toString(){
            return "img/Little_Icons/items/apple.png";
        }
    },
    CANDY(75){
        public String toString(){
            return "img/Little_Icons/items/candy.png";
        }
    },





    //endregion Items

    //region  Green Ghost Ginkey
    GINKEY_DOWN(0){
        public String toString(){
            return "img/Little_Icons/greenGhost/LittleGreenGhostDown.png";
        }
    },

    GINKEY_UP(0){
        public String toString(){
            return "img/Little_Icons/greenGhost/LittleGreenGhostUp.png";
        }
    },

    GINKEY_LEFT(0){
        public String toString(){
            return "img/Little_Icons/greenGhost/LittleGreenGhostLeft.png";
        }
    },

    GINKEY_RIGHT(0){
        public String toString(){
            return "img/Little_Icons/greenGhost/LittleGreenGhostRight.png";
        }
    },

    //endregion Green Ghost Ginkey

    //region Orange Ghost Inkey

    INKEY_DOWN(0){
        public String toString(){
            return "img/Little_Icons/orangeGhost/LittleOrangeGhostDown.png";
        }
    },

    INKEY_UP(0){
        public String toString(){
            return "img/Little_Icons/orangeGhost/LittleOrangeGhostUp.png";
        }
    },

    INKEY_LEFT(0){
        public String toString(){
            return "img/Little_Icons/orangeGhost/LittleOrangeGhostLeft.png";
        }
    },

    INKEY_RIGHT(0){
        public String toString(){
            return "img/Little_Icons/orangeGhost/LittleOrangeGhostRight.png";
        }
    },


    //endregion Orange Ghost Inkey

    //region Red Ghost Blinkey
    BLINKEY_DOWN(0){
        public String toString(){
            return "img/Little_Icons/redGhost/LittleRedGhostDown.png";
        }
    },

    BLINKEY_UP(0){
        public String toString(){
            return "img/Little_Icons/redGhost/LittleRedGhostUp.png";
        }
    },

    BLINKEY_LEFT(0){
        public String toString(){
            return "img/Little_Icons/redGhost/LittleRedGhostLeft.png";
        }
    },

    BLINKEY_RIGHT(0){
        public String toString(){
            return "img/Little_Icons/redGhost/LittleRedGhostRight.png";
        }
    },

    //endregion Red Ghost Blinkey

    //region Pink Ghost Pinkey
    PINKEY_DOWN(0){
        public String toString(){
            return "img/Little_Icons/pinkGhost/LittlePinkGhostDown.png";
        }
    },

    PINKEY_UP(0){
        public String toString(){
            return "img/Little_Icons/pinkGhost/LittlePinkGhostUP.png";
        }
    },

    PINKEY_LEFT(0){
        public String toString(){
            return "img/Little_Icons/pinkGhost/LittlePinkGhostLeft.png";
        }
    },

    PINKEY_RIGHT(0){
        public String toString(){
            return "img/Little_Icons/pinkGhost/LittlePinkGhostRight.png";
        }
    },

    //endregion Pink Ghost Pinkey

    //region Omer Ghost
    OMER_DOWN(0){
        public String toString(){
            return "img/Little_Icons/OmerGhost/Omer_Down.png";
        }
    },
    OMER_LEFT(0){
        public String toString(){
            return "img/Little_Icons/OmerGhost/Omer_Left.png";
        }
    },
    OMER_RIGHT(0){
        public String toString(){
            return "img/Little_Icons/OmerGhost/Omer_Right.png";
        }
    },
    OMER_UP(0){
        public String toString(){
            return "img/Little_Icons/OmerGhost/Omer_Up.png";
        }
    },


    //endregion Omer Ghost

    //region Weapons

    //region FireBall

    FIRE_BALL_RIGHT(0){
        public String toString(){
            return "img/Little_Icons/weapons/fireball/fireBallRight.gif";
        }
    },
    FIRE_BALL_LEFT(0){
        public String toString(){
            return "img/Little_Icons/weapons/fireball/fireBallLeft.gif";
        }
    },
    FIRE_BALL_UP(0){
        public String toString(){
            return "img/Little_Icons/weapons/fireball/fireBallUp.gif";
        }
    },
    FIRE_BALL_DOWN(0){
        public String toString(){
            return "img/Little_Icons/weapons/fireball/fireBallDown.gif";
        }
    },

    //endregion FireBall

    //region WaterBall
    WATER_BALL_DOWN(0){
        public String toString(){
            return "img/Little_Icons/weapons/waterBall/waterBallDown.gif";
        }
    },
    WATER_BALL_LEFT(0){
        public String toString(){
            return "img/Little_Icons/weapons/waterBall/waterBallLeft.gif";
        }
    },
    WATER_BALL_RIGHT(0){
        public String toString(){
            return "img/Little_Icons/weapons/waterBall/WaterBallRight.gif";
        }
    },
    WATER_BALL_UP(0){
        public String toString(){
            return "img/Little_Icons/weapons/waterBall/WaterBallUp.gif";
        }
    },

    //endregion WaterBall

    SMALL_BOMB(0){
        public String toString(){
            return "img/Little_Icons/weapons/smallestbomb.png";
        }
    },
    MIDDLE_BOMB(0){
        public String toString(){
            return "img/Little_Icons/weapons/mid-smallBomb.png";
        }
    },
    LARGE_BOMB(0){
        public String toString(){
            return "img/Little_Icons/weapons/biggestBomb.png";
        }
    },
    LIGHTNING_UP_DOWN(0){
        public String toString(){
            return "img/Little_Icons/weapons/lightning/LightningUpDown.gif";
        }
    },
    LIGHTNING_LEFT_RIGHT(0){
        public String toString(){
            return "img/Little_Icons/weapons/lightning/lightningLeftRight.gif";
        }
    },
    EXPLOSION(0){
        public String toString(){
            return "img/Little_Icons/weapons/explosion.png";
        }
    },


    //endregion Weapons

    //region Effects

    ANIMATED_EXPLOSION_1(0){
        public String toString(){
            return "img/Little_Icons/weapons/animatedExplosion1.gif";
        }
    },
    ANIMATED_EXPLOSION_2(0){
        public String toString(){
            return "img/Little_Icons/weapons/animatedExplosion2.gif";
        }
    },

    FROZEN (0){
        public String toString() {
            return "img/Little_Icons/frozen.gif";
        }
    },

    TRANSPARENT(0){
        public String toString() {
            return "img/Little_Icons/transperantCube.png";
        }
    },

    GRAVE(0){
        public String toString() {
            return "img/Little_Icons/cartoonedGrave.png";
        }
    };

    //endregion Effects

    private final int score;
    private SourceURL(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

}

