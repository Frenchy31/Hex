/**
 * @author RIOU PUYOOU S3C
 */
package Model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Frenchy on 02/12/2015.
 */
public class GameBoardTest {

    @Test
    public void testGenerateGraphicCellX() throws Exception {
        GameBoard gameBoard = new GameBoard(10,10);
        int ligne = 1;
        assertEquals((GameBoard.getIntervalLeftScreen() + ligne * gameBoard.getCellDiameter()
                - (ligne * 6)),gameBoard.generateGraphicCellX(ligne), 0);
    }

    @Test
    public void testGenerateGraphicCellY() throws Exception {
        GameBoard gameBoard = new GameBoard(10,10);
        int ligne = 1;
        int colonne = 1;
        assertEquals((GameBoard.getIntervalTopScreen() + colonne * gameBoard.getCellDiameter()
                - (ligne * 20)),gameBoard.generateGraphicCellY(colonne, ligne), 0);
    }

    @Test
    public void testResetCells() throws Exception {
        GameBoard gameBoard = new GameBoard(10,10);

    }
}