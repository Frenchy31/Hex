/**
 * @author RIOU PUYOOU S3C
 */
package Model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Frenchy on 02/12/2015.
 */
public class ModelTest {

    @Test
    public void testChangeColor() throws Exception {
        Model model = new Model();
        Cell c = new Cell(0,0,0,0, Color.WHITE,20);
        model.changeColor(c);
        assertEquals(c.getColor(), Color.BLUE);
        model.getPlayer().changePlayer();

    }

    @Test
    public void testReset() throws Exception {
        GameBoard gb = new GameBoard(10,10);
        Player player = new Player();
        Model modelOne = new Model(gb);
        modelOne.setPlayer(player);
        Model modelTwo = new Model(gb);
        modelTwo.setPlayer(player);
        modelOne.reset();
        assertEquals(modelOne.getGameBoard(), modelTwo.getGameBoard());
        assertNull(modelOne.getWinnerColor());
        assertFalse(modelOne.isInGame());
        assertEquals(modelOne.getPlayer(), modelTwo.getPlayer());
    }
}