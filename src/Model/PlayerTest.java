/**
 * @author RIOU PUYOOU S3C
 */
package Model;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class PlayerTest {

    public void testChangePlayer(){
        Player p = new Player();
        p.changePlayer();
        assertEquals(p.getTurn(), 2);
        p.changePlayer();
        assertEquals(p.getTurn(), 1);
    }

    public void testPlay(){
        Player p = new Player();
        assertEquals(p.play(), Color.BLUE);
        p.setTurn(2);
        assertEquals(p.play(), Color.RED);
    }
}
