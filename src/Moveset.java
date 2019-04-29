public class Moveset {
    private Player player;
    private GridPiece gridPiece;

    public Moveset(Player player, GridPiece gridPiece){
        this.player = player;
        this.gridPiece = gridPiece;
    }

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }

    public GridPiece getGridPiece() {
        return gridPiece;
    }
    public void setGridPiece(GridPiece gridPiece) {
        this.gridPiece = gridPiece;
    }
}
