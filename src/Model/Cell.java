/**
 * @author RIOU PUYOOU S3C
 */
package Model;

import java.awt.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Cell extends Polygon implements Serializable{

	/**
	 * Position X sur le plateau
	 */
	private int myGameBoardX;

	/**
	 * Position Y sur le plateau
	 */
	private int myGameBoardY;

	/**
	 * Position X en pixels sur la fenêtre
	 */
	private double myGraphicX;
	/**
	 * Position Y en pixels sur la fenêtre
	 */
	private double myGraphicY;

	/**
	 * Couleur de fond
	 */
	private Color myColor;

	/**
	 * Rayon
	 */
	private int myRadius;

	/**
	 * Arc du polygone
	 */
	private static final double POLYGON_ARC = (Math.PI * 2) / 6;

	/**
	 * Passe a true si la cellule a été visité
	 * lors de l'algorithme de victoire
	 */
	private boolean visited = false;

	/**
	 * Passe a true si un joueur a rempli la case
	 */
	private boolean filled = false;

	/**
	 * Constructeur paramétré
	 *
	 * @param gameBoardX
	 * @param gameBoardY
	 * @param graphicX
	 * @param graphicY
	 * @param color
	 * @param radius
	 */
	public Cell(int gameBoardX, int gameBoardY, double graphicX, double graphicY,
				Color color, int radius) {
		this.myGameBoardX = gameBoardX;
		this.myGameBoardY = gameBoardY;
		this.myGraphicX = graphicX;
		this.myGraphicY = graphicY;
		this.myColor = color;
		this.myRadius = radius;
		this.formPolygon();
	}


	/**
	 * @return Cell.myGameBoardX
	 */
	public int getGameBoardX() {
		return this.myGameBoardX;
	}

	/**
	 * @return Cell.myGameBoardY
	 */
	public int getGameBoardY() {
		return this.myGameBoardY;
	}

	/**
	 * @return Cell.myGraphicX
	 */
	public double getGraphicX() {
		return this.myGraphicX;
	}

	/**
	 * @return Cell.myGraphicY
	 */
	public double getGraphicY() {
		return this.myGraphicY;
	}

	/**
	 * Changer la position sur la fen�tre en X
	 *
	 * @param x
	 */
	public void setGraphicX(double x) {
		this.myGraphicX = x;
	}

	/**
	 * Changer la position sur la fen�tre en Y
	 *
	 * @param y
	 */
	public void setGraphicY(double y) {
		this.myGraphicY = y;
	}

	/**
	 * Change la couleur de la cellule
	 *
	 * @param color
	 */

	public void setColor(Color color) {
		this.myColor = color;
	}

	/**
	 * @return Cell.myColor
	 */
	public Color getColor() {
		return this.myColor;
	}

	/**
	 * @return Cell.myRadius
	 */
	public float getRadius() {
		return this.myRadius;
	}

	/**
	 * @return Cell.myPolygonArc
	 */
	public double getPolygonArc() {
		return POLYGON_ARC;
	}

	/**
	 * Retourne le X du centre de la cellule
	 *
	 * @return Cell.myGraphicX + Cell.myRadius
	 */
	public double getGraphicCenterX() {
		return this.myGraphicX + this.myRadius;
	}

	/**
	 * Retourne le Y du centre de la cellule
	 *
	 * @return Cell.myGraphicY + Cell.myRadius
	 */
	public double getGraphicCenterY() {
		return this.myGraphicY + this.myRadius;
	}

	/**
	 * @return Cell.filled
	 */
	public boolean isFilled() {
		return this.filled;
	}

	/**
	 * Modifie Cell.filled
	 *
	 * @param filled
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/**
	 * @return Cell.visited
	 */
	public boolean isVisited() {

		return this.visited;
	}

	/**
	 * Modifie Cell.visited
	 *
	 * @param visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * Place les points de la cellule
	 */
	public void formPolygon() {
		for (int i = 0; i <= 6; i++) {
			this.addPoint(
					(int) Math.round(this.getGraphicCenterX() + this.getRadius()
							* Math.cos(this.getPolygonArc() * i)),
					(int) Math.round(this.getGraphicCenterY() + this.getRadius()
							* Math.sin(this.getPolygonArc() * i)));

		}
	}

	/**
	 * Retourne un polygone correspondant aux bords
	 * @param ligne
	 * @param colonne
	 * @param firstPoint
	 * @param nbPoints
	 * @return
	 */
	public Polygon getCellsBorder(int ligne, int colonne, int firstPoint, int nbPoints){
		Polygon borderPolygon = new Polygon();
		int borderRadius = this.myRadius+5;
		borderPolygon.addPoint((int) getGraphicCenterX(),(int) getGraphicCenterY());
		if(this.myGameBoardY == 0 || this.myGameBoardX == 0
				|| this.myGameBoardY == ligne-1 || this.myGameBoardX == colonne -1){
			for (int i=0; i<nbPoints;i++){
				insertPointPolygon(borderPolygon,borderRadius,(firstPoint+i)%6);
			}
		}
		return borderPolygon;
	}

	/**
	 * Ajoute les points au polygone de bordure
	 * @param polygon
	 * @param radius
	 * @param nb
	 */
	private void insertPointPolygon(Polygon polygon, int radius, int nb){
		polygon.addPoint((int) Math.round(this.getGraphicCenterX() + radius * Math.cos(POLYGON_ARC*nb)),
				(int) Math.round(this.getGraphicCenterY()+ radius * Math.sin(POLYGON_ARC*nb)));
	}
}