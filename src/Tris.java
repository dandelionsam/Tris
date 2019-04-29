import java.util.ArrayList;

public class Tris {
    private GridPiece[] playGrid;
    private ArrayList<Moveset> moveHistory;
    private Player[] players;

    public Tris(Player playerOne, Player playerTwo){
        players = new Player[2];
        players[0] = playerOne;
        players[1] = playerTwo;

        moveHistory = new ArrayList<>();

        playGrid = new GridPiece[9];
        createEmptyGrid(playGrid);
    }

    public GridPiece[] getPlayGrid() { return playGrid; }
    public void setPlayGrid(GridPiece[] playGrid) { this.playGrid = playGrid; }

    public GridPiece getPlayGridPiece(int gridPieceIndex) { return playGrid[gridPieceIndex]; }

    public ArrayList<Moveset> getMoveHistory() { return moveHistory; }
    public void setMoveHistory(ArrayList<Moveset> moveHistory) { this.moveHistory = moveHistory; }

    public Player[] getPlayers() { return players; }
    public void setPlayers(Player[] players) { this.players = players; }

    public void getGameStatusCode(){

        /* This method is used to get a status code which tells the actual status of the game.

            Returns -1 if there are yet spaces in the grid that could be filled
            Returns 0 if the game is draw
            Returns 1 if the Player 1 won the game
            Returns 2 if the Player 2 won the game

         */

        int statusCode = -1;
        boolean result = false;

        if (moveHistory.size() > 5 && moveHistory.size() < 9){

            // CheckRows
            if (playGrid[0].getFillSign() != '_' && playGrid[0].getFillSign().equals(playGrid[1].getFillSign()) && playGrid[1].getFillSign().equals(playGrid[2].getFillSign())) result = true;
            if (playGrid[0].getFillSign() != '_' && playGrid[3].getFillSign().equals(playGrid[4].getFillSign()) && playGrid[4].getFillSign().equals(playGrid[5].getFillSign())) result = true;
            if (playGrid[0].getFillSign() != '_' && playGrid[6].getFillSign().equals(playGrid[7].getFillSign()) && playGrid[7].getFillSign().equals(playGrid[8].getFillSign())) result = true;

            // CheckCols
            if (playGrid[0].getFillSign() != '_' && playGrid[0].getFillSign().equals(playGrid[3].getFillSign()) && playGrid[3].getFillSign().equals(playGrid[6].getFillSign())) result = true;
            if (playGrid[1].getFillSign() != '_' && playGrid[1].getFillSign().equals(playGrid[4].getFillSign()) && playGrid[4].getFillSign().equals(playGrid[7].getFillSign())) result = true;
            if (playGrid[2].getFillSign() != '_' && playGrid[2].getFillSign().equals(playGrid[5].getFillSign()) && playGrid[5].getFillSign().equals(playGrid[8].getFillSign())) result = true;

            // CheckDiag
            if (playGrid[0].getFillSign() != '_' && playGrid[0].getFillSign().equals(playGrid[4].getFillSign()) && playGrid[4].getFillSign().equals(playGrid[8].getFillSign())) result = true;
            if (playGrid[2].getFillSign() != '_' && playGrid[2].getFillSign().equals(playGrid[4].getFillSign()) && playGrid[4].getFillSign().equals(playGrid[6].getFillSign())) result = true;
        }

        if(moveHistory.size() == 9 && !result) statusCode = 0;
        if(result && playGrid[0].getFillSign() == players[0].getPlayerChar()) statusCode = 1;
        if(result && playGrid[0].getFillSign() == players[1].getPlayerChar()) statusCode = 2;

        System.out.println("\r\n" + "Il gioco è finito con status: " + statusCode);
    }

    public void registerMove(Moveset m){
        for (int i = 0; i < playGrid.length; i++)
        {
            if (playGrid[i].equals(m.getGridPiece()))
            {
                // Registra mossa attuale nello storico delle mosse
                moveHistory.add(m);

                // Registra casella selezionata non più vuota e assegna il segno giocato alla casella
                playGrid[i].setEmpty(false);
                playGrid[i].setFillSign(m.getPlayer().getPlayerChar());
            }
        }
    }

    private void createEmptyGrid(GridPiece[] playGrid){
        playGrid[0] = new GridPiece(1,1,true);
        playGrid[1] = new GridPiece(2,1,true);
        playGrid[2] = new GridPiece(3,1,true);
        playGrid[3] = new GridPiece(1,2,true);
        playGrid[4] = new GridPiece(2,2,true);
        playGrid[5] = new GridPiece(3,2,true);
        playGrid[6] = new GridPiece(1,3,true);
        playGrid[7] = new GridPiece(2,3,true);
        playGrid[8] = new GridPiece(3,3,true);
    }

    public void printDebugGrid(){
        for (int i = 0; i < playGrid.length; i++) System.out.println(playGrid[i]);
    }

    public void printGameGrid(){
        System.out.print(playGrid[0].getFillSign());
        System.out.print(playGrid[1].getFillSign());
        System.out.println(playGrid[2].getFillSign());
        System.out.print(playGrid[3].getFillSign());
        System.out.print(playGrid[4].getFillSign());
        System.out.println(playGrid[5].getFillSign());
        System.out.print(playGrid[6].getFillSign());
        System.out.print(playGrid[7].getFillSign());
        System.out.print(playGrid[8].getFillSign());
    }
}
