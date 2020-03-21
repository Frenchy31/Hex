/**
 * @author RIOU PUYOOU S3C
 */
package Controller;

import java.awt.Point;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Model.Cell;
import Model.Model;

public class Controller {

    /**
     * Model du Controller
     */
    protected Model myModel;

    /**
     * Constructeur
     * @param model
     */
    public Controller(Model model) {
        this.myModel = model;
    }

    /**
     * Modifie Controller.myModel.inGame
     * @param playing
     */
    public void setPlaying(boolean playing) {
        this.myModel.setInGame(playing);
    }

    /**
     * Appelle la fonction du modele qui colorie la
     * cellule
     * @param p
     */
    public void colorize(Point p) {
        for (Cell c : this.myModel.getGameBoard().getCellCollection()) {
            if (c.contains(p) && !c.isFilled()) {
                myModel.changeColor(c);
                c.setFilled(true);
            }
        }
    }

    /**
     * Remise à 0 du Model
     */
    public void resetModel() {
        this.myModel.reset();
    }
}