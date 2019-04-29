import java.util.Scanner;

public class Game {

    // Scanner scanner = new Scanner(System.in);


    public static final void main (String args[]){

        // Program Flow
        // 1. Apro il Tris

        // 2. Creo player1 e player2
        // 3. Seleziono il segno di player1 e player2
        Player one = new Player("Pippo", 'x');
        Player two = new Player("Pluto", 'o');

        // 4. Comincia il gioco
        Tris tris = new Tris(one, two);

        // 5. Cominciano i turni
        // 6. Turno di [p]
        //      a. [p] indica una casella
        //      b. Creo un oggetto Moveset, associando la casella indicata al giocatore attuale
        //      c. Registro la mossa sulla griglia e sullo storico delle mosse

        // tris.registerMove(new Moveset([playerName], tris.getPlayGridPiece(indexOf));

        // for (int i = 0; i < 9; i += 2) tris.registerMove(new Moveset(one, tris.getPlayGridPiece(i)));
        // for (int i = 1; i < 9; i += 2) tris.registerMove(new Moveset(two, tris.getPlayGridPiece(i)));
        // for (int i = 0; i < 8; i++) tris.registerMove(new Moveset(two, tris.getPlayGridPiece(i)));

        //tris.printDebugGrid();

        tris.registerMove(new Moveset(one, tris.getPlayGridPiece(0)));
        tris.registerMove(new Moveset(two, tris.getPlayGridPiece(1)));
        tris.registerMove(new Moveset(two, tris.getPlayGridPiece(2)));
        //tris.registerMove(new Moveset(one, tris.getPlayGridPiece(3)));
        tris.registerMove(new Moveset(one, tris.getPlayGridPiece(4)));
        //tris.registerMove(new Moveset(one, tris.getPlayGridPiece(5)));
        tris.registerMove(new Moveset(one, tris.getPlayGridPiece(6)));
        //tris.registerMove(new Moveset(two, tris.getPlayGridPiece(7)));
        tris.registerMove(new Moveset(two, tris.getPlayGridPiece(8)));

        tris.printGameGrid();

        tris.getGameStatusCode();
    }
}
