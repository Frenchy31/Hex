/**
 * @author RIOU PUYOOU S3C
 */
package Model;

import java.awt.Color;
import java.io.Serializable;

public class Player implements Serializable{
	/**
	 * Tour du Joueur
	 */
	private int turn;

	/**
	 * Constructeur, Player.turn=1
	 */
	public Player(){
		this.turn=1;
	}

	/**
	 * Modifie Player.turn
	 * @param turn
	 */
	public void setTurn(int turn){
		this.turn = turn;
	}

	/**
	 * @return Player.turn
	 */
	public int getTurn(){
		return this.turn;
	}

	/**
	 * Passe Player.turn a 2 si il est a 1
	 * et vice-versa
	 */
	public void changePlayer(){
		if (turn == 1)
			turn = 2;
		else
			turn = 1;
	}

	/**
	 * Retourne la couleur correspondant au joueur
	 * @return Color.BLUE
	 * @return Color.RED
	 */
	public Color play(){
		if (turn == 1)
			return Color.BLUE;
		else
			return Color.RED;
	}

}
