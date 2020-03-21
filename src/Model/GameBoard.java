/**
 * @author RIOU PUYOOU S3C
 */
package Model;

import java.awt.Color;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GameBoard implements Serializable{

	/**
	 * CONSTANTE
	 * Rayon de la cellule
	 */
	private static final int CELL_RADIUS = 20;

	/**
	 * CONSTANTE
	 * Nombre de pixels de décalage par rapport au bord gauche de l'écran
	 */
	private static final int INTERVAL_LEFT_SCREEN = 250;



	/**
	 * CONSTANTE
	 * Nombre de pixels de décalage par rapport au bord du haut de l'écran
	 */
	private static final int INTERVAL_TOP_SCREEN = 200;

	/**
	 * Nombre de lignes de la grille
	 */
	private int myNbLines;

	/**
	 * Nombre de colonnes de la grille
	 */
	private int myNbColumns;

	/**
	 * Collection de cellules de la classe GameBoard
	 */
	private ArrayList<Cell> myCellCollection;

	public GameBoard(int nbLines, int nbColumns) {

		this.myNbLines = nbLines;
		this.myNbColumns = nbColumns;

		myCellCollection = new ArrayList<Cell>();
		for (int ligne = 0; ligne < myNbLines; ligne++) {
			for (int colonne = 0; colonne < myNbColumns; colonne++) {
				generateCell(colonne,ligne );
			}
		}
	}

	/**
	 * Retourne un X Graphique permettant de resserer les cellules dans la
	 * fen�tre
	 *
	 * @param ligne
	 * @return INTERVAL_LEFT_SCREEN + ligne * this.getCellDiameter()
	- (ligne * 6)
	 */
	public double generateGraphicCellX(int ligne) {
		return INTERVAL_LEFT_SCREEN + ligne * this.getCellDiameter()
				- (ligne * 6);
	}

	/**
	 * Retourne un Y Graphique permettant de resserer les cellules dans la
	 * fen�tre
	 *
	 * @param colonne
	 * @param ligne
	 * @return INTERVAL_TOP_SCREEN + colonne * this.getCellDiameter()
	- (ligne * 20)
	 */

	public double generateGraphicCellY(int colonne, int ligne) {
		return INTERVAL_TOP_SCREEN + colonne * this.getCellDiameter()
				- (ligne * 20);
	}

	/**
	 * G�n�re les cellules du plateau
	 * @param ligne
	 * @param colonne
	 */
	public void generateCell(int ligne, int colonne){
		Cell c = new Cell(ligne, colonne, this.generateGraphicCellX(ligne),
				this.generateGraphicCellY(colonne, ligne), Color.WHITE,
				CELL_RADIUS);
		myCellCollection.add(c);
	}

	/**
	 * Remet toutes les cellules en Blanc
	 */
	public void resetCells(){
		for(Cell c : this.myCellCollection){
			c.setColor(Color.WHITE);
		}
	}

	/**
	 * @return GameBoard.myCellCollection
	 */
	public ArrayList<Cell> getCellCollection() {
		return this.myCellCollection;
	}

	/**
	 * @return CELL_RADIUS*2
	 */
	public int getCellDiameter() {
		return (CELL_RADIUS * 2);
	}

	/**
	 * @return this.INTERVAL_TOP_SCREEN
	 */
	public static int getIntervalTopScreen() {
		return INTERVAL_TOP_SCREEN;
	}

	/**
	 * @return this.INTERVAL_LEFT_SCREEN
	 */
	public static int getIntervalLeftScreen() {
		return INTERVAL_LEFT_SCREEN;
	}

	/**
	 * Modifie une cellule du tableau
	 * @param c
	 */
	public void setCell(Cell c) {
		for(Cell cell : myCellCollection){
			if (samePosition(c, cell)){
				cell = c;
			}
		}
	}

	/**
	 * @param c
	 * @param cell
	 * @return
	 */
	public boolean samePosition(Cell c, Cell cell) {
		return c.getGameBoardX() == cell.getGameBoardX() && c.getGameBoardY() == cell.getGameBoardY();
	}


}