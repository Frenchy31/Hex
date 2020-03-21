/**
 * @author RIOU PUYOOU S3C
 */
package Model;

import com.sun.javafx.sg.prism.NGShape;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable implements Serializable{

    /**
     * CONSTANTE Nombre de lignes du plateau
     */
    private final int NB_LINES = 7;

    /**
     * CONSTANTE Nombre de lignes du plateau
     */
    private final int NB_COLUMNS = 7;

    /**
     * Plateau
     */
    private GameBoard myGameBoard;

    /**
     * Numero du joueur
     *
     */
    private Player myPlayer;

    /**
     * Couleur du gagnant
     */
    private Color myWinnerColor;

    /**
     * Passe a true si on est en jeu
     */
    private boolean inGame;


    /**
     * Constructeur par d�faut
     */
    public Model() {
        myGameBoard = new GameBoard(NB_LINES, NB_COLUMNS);
        this.myPlayer = new Player();
        this.inGame = false;
    }

    public Model(Model model){
        this.myGameBoard = model.getGameBoard();
        this.myPlayer = model.getPlayer();
        this.myWinnerColor = model.getWinnerColor();
        this.setInGame(model.isInGame());
    }
    /**
     * Constructeur paramétré
     *
     * @param gameBoard
     */
    public Model(GameBoard gameBoard) {
        //player = false;
        this.myGameBoard = gameBoard;
        this.myPlayer = new Player();
    }

    /**
     * @return Model.myGameboard
     */
    public GameBoard getGameBoard() {
        return this.myGameBoard;
    }

    /**
     * @return Model.inGame
     */
    public boolean isInGame() {
        return inGame;
    }

    /**
     * Modifie Model.inGame
     * @param inGame
     */
    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    /**
     * Modifie Model.myGameBoard
     * @param gameBoard
     */
    public void setGameBoard(GameBoard gameBoard) {
        this.myGameBoard = gameBoard;
    }

    /**
     * @return Model.myWinnerColor
     */
    public Color getWinnerColor() {
        return this.myWinnerColor;
    }

    /**
     * Modifie le joueur
     * @param player
     */
    public void setPlayer(Player player) {
        this.myPlayer = player;
    }

    /**
     * @return Model.myPlayer
     */
    public Player getPlayer() {
        return this.myPlayer;
    }

    /**
     * Change la couleur de la cellule en fonction du joueur
     * @param c
     */
    public void changeColor(Cell c){
        if(!c.isFilled()){
            c.setColor(this.myPlayer.play());
            if(this.inGame && this.victory()){
                this.myWinnerColor = myPlayer.play();
                this.inGame = false;
            }
            if(this.inGame)
                this.myPlayer.changePlayer();

        }
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Retourne vrai si un joueur a gagne
     */
    public boolean victory() {

        if(myPlayer.getTurn()==1){
            for(Cell c : this.myGameBoard.getCellCollection()){
                if (c.getColor() == Color.BLUE && c.getGameBoardY() == 0  &&  this.recursiveVictory(myPlayer.play(), c))
                    return true;
            }
        }
        else {
            for (Cell c : this.myGameBoard.getCellCollection()) {
                if (c.getColor() == Color.RED && c.getGameBoardX() == 0 && this.recursiveVictory(myPlayer.play(), c))
                    return true;
            }
        }

        return false;
    }

    /**
     * Verifie la couleur de toutes les cellules autour de celle mise
     * en parametre
     * Si on arrive a une cellule sur la derniere ligne ou la derniere colonne,
     * l'algorithme retourne vrai
     * @param play
     * @param cell
     */
    private boolean recursiveVictory(Color play, Cell cell){
        if(play == Color.BLUE && cell.getGameBoardY()==NB_LINES-1)
            return true;
        else if(play == Color.RED && cell.getGameBoardX()==NB_COLUMNS-1)
            return true;
        cell.setVisited(true);
        for(Cell c : this.checkAround(cell)){
            if( !c.isVisited() && c.getColor() == cell.getColor() && recursiveVictory(play, c)){
                cell.setVisited(false);
                return true;
            }
        }
        cell.setVisited(false);
        return false;
    }

    /**
     * Retourne un tableau de Cellules correspondant
     * aux cellules autour de celle mise en param�tre
     * @param cell
     * @return aroundCells
     */
    private ArrayList<Cell> checkAround(Cell cell) {
        ArrayList<Cell> aroundCells = new ArrayList<Cell>();
        for(Cell c : myGameBoard.getCellCollection())
        {
            if(c.getGameBoardY() == cell.getGameBoardY()-1 && c.getGameBoardX() == cell.getGameBoardX())
                aroundCells.add(c);
            if(c.getGameBoardY() == cell.getGameBoardY() && c.getGameBoardX() == cell.getGameBoardX()+1)
                aroundCells.add(c);
            if(c.getGameBoardY() == cell.getGameBoardY()+1 && c.getGameBoardX() == cell.getGameBoardX()+1)
                aroundCells.add(c);
            if(c.getGameBoardY() == cell.getGameBoardY()+1 && c.getGameBoardX() == cell.getGameBoardX())
                aroundCells.add(c);
            if(c.getGameBoardY() == cell.getGameBoardY() && c.getGameBoardX() == cell.getGameBoardX()-1)
                aroundCells.add(c);
            if(c.getGameBoardY() == cell.getGameBoardY()-1 && c.getGameBoardX() == cell.getGameBoardX()-1)
                aroundCells.add(c);
        }
        return aroundCells;
    }

    /**
     * Remise a 0 du Model
     */
    public void reset(){
        this.myGameBoard.resetCells();
        this.myWinnerColor = null;
        this.setInGame(false);
        this.myPlayer.setTurn(1);
    }

    public int getNbLines() {
        return NB_LINES;
    }

    public int getNbColumns() {
        return NB_COLUMNS;
    }

}
