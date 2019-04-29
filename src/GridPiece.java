public class GridPiece {
    private int xPos;
    private int yPos;
    private boolean isEmpty;
    private Character fillSign;

    public GridPiece(int xPos, int yPos, boolean isEmpty){
        this.xPos = xPos;
        this.yPos = yPos;
        this.isEmpty = isEmpty;
        this.fillSign = '_';
    }

    public int getXPos() {
        return xPos;
    }
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }
    public void setPPos(int yPos) {
        this.yPos = yPos;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Character getFillSign() {
        return fillSign;
    }
    public void setFillSign(Character fillSign) {
        this.fillSign = fillSign;
    }

    @Override
    public String toString(){
        return "x-> " + this.xPos + " - " + "y-> " + this.yPos + " | " + "Empty: " + this.isEmpty + " | " + "Filling char: " + this.getFillSign();
    }
}
