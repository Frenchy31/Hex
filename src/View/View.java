/**
 * @author RIOU PUYOOU S3C
 */
package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import Controller.Controller;
import Model.Model;

@SuppressWarnings("serial")
public class View extends JFrame implements Observer, ActionListener {

    /**
     * Chemin vers l'image de fond
     */
    private String myBackgroundImagePath;

    /**
     * Model de View 
     */
    private Model myModel;

    /**
     * PanelMenu de View
     */
    private PanelMenu myPanelMenu;

    /**
     * PanelGame de View
     */
    private PanelGame myPanelGame;

    /**
     * Controller de View
     */
    private Controller myController;

    /**
     * Click de View
     */
    private Click myClick;

    /**
     * Largeur de l'écran
     */
    private final int SCREEN_WIDTH = 800;

    /**
     * Hauteur de l'écran
     */
    private final int SCREEN_HEIGHT = 600;

    /**
     * Constructeur
     * @param model
     * @param controller
     */
    public View(Model model, Controller controller) {
        this.myModel = model;
        this.myModel.addObserver(this);
        this.myController = controller;
        this.myClick = new Click(this.myController);
        this.myBackgroundImagePath = "img/Default.jpg";
        this.initPanelMenu();
        this.initPanelGame();
        this.initFrame();
        this.initActionListener();
    }

    /**
     * Parametre View
     */
    public void initFrame() {
        this.setTitle("PUYOOU Aubin, RIOU Maxence S3C");
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.getContentPane().add(myPanelMenu, BorderLayout.CENTER);
        this.add(myPanelMenu, BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * Parametre View.myPanelGame
     */
    public void initPanelGame() {
        this.myPanelGame = new PanelGame(this.myModel);
        this.myPanelGame.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.myPanelGame.addBackgroundImage(this.myBackgroundImagePath);
        this.myPanelGame.addMouseListener(this.myClick);
    }

    /**
     * Parametre View.myPanelMenu
     */
    public void initPanelMenu() {
        this.myPanelMenu = new PanelMenu();
        this.myPanelMenu.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.myPanelMenu.addBackgroundImage(this.myBackgroundImagePath);
        this.myPanelMenu.setVisible(true);
    }

    /**
     * @return this.myModel
     */
    public Model getModel() {
        return this.myModel;
    }

    /**
     * Modifie View.myModel
     * @param model
     */
    public void setModel(Model model) {
        this.myModel = model;
    }

    /**
     * Synchronisation de View avec son Model
     */
    @Override
    public void update(Observable obs, Object o) {
        this.myPanelGame.repaint();
        this.repaint();
        this.displayVictory();
    }

    /**
     * Traite les evenements de la fenetre
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myPanelMenu.getButtonPlay()) {
            this.changeFromMenuToGame();
            this.myPanelGame.repaint();
        }

        if (e.getSource() == myPanelMenu.getButtonQuit()) {
            System.exit(0);
        }

        if (this.myPanelGame != null && e.getSource() == myPanelGame.getMenuButton()) {
            this.changeFromGameToMenu();
        }

        this.treatSelectedBackgroundTheme(e);
    }

    /**
     * Verifie quel bouton est selectionne dans le panel
     * de JRadioButton
     * @param e
     */
    private void treatSelectedBackgroundTheme(ActionEvent e) {
        if (e.getSource() == myPanelMenu.getMyJRadioButtonEspace()) {
            clickOnSpaceButton();
        }
        if (e.getSource() == myPanelMenu.getMyJRadioButtonNature()) {
            clickOnNatureButton();
        }
        if (e.getSource() == myPanelMenu.getMyJRadioButtonPlage()) {
            clickOnBeachButton();
        }
        if (e.getSource() == myPanelMenu.getMyJRadioButtonVille()) {
            clickOnCityButton();
        }
        if (e.getSource() == myPanelMenu.getMyJRadioButtonDefaut()) {
            clickOnDefaultButton();
        }
    }

    /**
     * Modifie la vue lorsque le bouton Space est selectionne
     */
    public void clickOnSpaceButton() {
        this.setBackgroundImagePath("img/Space.jpg");

        if (!this.myModel.isInGame()) {
            this.myPanelMenu.addBackgroundImage(this.myBackgroundImagePath);
            this.myPanelMenu.repaint();
        }
        if (this.myPanelGame != null) {
            this.myPanelGame.addBackgroundImage(this.myBackgroundImagePath);
            this.myPanelGame.repaint();
        }
    }

    /**
     * Modifie la vue lorsque le bouton Nature est selectionne
     */
    public void clickOnNatureButton() {
        this.setBackgroundImagePath("img/Nature.jpg");
        if (!this.myModel.isInGame()) {

            this.myPanelMenu.addBackgroundImage(this.myBackgroundImagePath);
            this.myPanelMenu.repaint();
        }
        if (this.myPanelGame != null) {
            this.myPanelGame.addBackgroundImage(this.myBackgroundImagePath);
            this.myPanelGame.repaint();
        }
    }

    /**
     * Modifie la vue lorsque le bouton Beach est selectionne
     */
    public void clickOnBeachButton() {
        this.setBackgroundImagePath("img/Beach.jpg");
        if (!this.myModel.isInGame()) {
            this.myPanelMenu.addBackgroundImage(this.myBackgroundImagePath);
            this.myPanelMenu.repaint();
        }
        if (this.myPanelGame != null) {
            this.myPanelGame.addBackgroundImage(this.myBackgroundImagePath);
            this.myPanelGame.repaint();
        }
    }

    /**
     * Modifie la vue lorsque le bouton City est selectionne
     */
    public void clickOnCityButton() {
        this.setBackgroundImagePath("img/City.jpg");
        if (!this.myModel.isInGame()) {
            this.myPanelMenu.addBackgroundImage(this.myBackgroundImagePath);
            this.myPanelMenu.repaint();
        }
        if (this.myPanelGame != null) {
            this.myPanelGame.addBackgroundImage(this.myBackgroundImagePath);
            this.myPanelGame.repaint();
        }
    }

    /**
     * Modifie la vue lorsque le bouton Default est selectionne
     */
    public void clickOnDefaultButton() {
        this.setBackgroundImagePath("img/Default.jpg");
        if (!this.myModel.isInGame()) {
            this.myPanelMenu.addBackgroundImage(this.myBackgroundImagePath);
            this.myPanelMenu.repaint();
        }
        if (this.myPanelGame != null) {
            this.myPanelGame.addBackgroundImage(this.myBackgroundImagePath);
            this.myPanelGame.repaint();
        }
    }

    /**
     * Initialise les ecouteurs sur les elements de
     * la fenetre
     */
    public void initActionListener() {
        this.myPanelMenu.getButtonPlay().addActionListener(this);
        this.myPanelMenu.getButtonQuit().addActionListener(this);
        this.myPanelMenu.getMyJRadioButtonEspace().addActionListener(this);
        this.myPanelMenu.getMyJRadioButtonPlage().addActionListener(this);
        this.myPanelMenu.getMyJRadioButtonNature().addActionListener(this);
        this.myPanelMenu.getMyJRadioButtonVille().addActionListener(this);
        this.myPanelMenu.getMyJRadioButtonDefaut().addActionListener(this);
        this.myPanelGame.getMenuButton().addActionListener(this);


    }

    /**
     * Traite le passage de la fenetre de menu
     * a la fenetre de jeu
     */
    public void changeFromMenuToGame() {
        this.myController.setPlaying(true);
        this.myPanelMenu.setVisible(false);
        this.remove(myPanelMenu);
        this.myPanelGame.setVisible(true);
        this.add(myPanelGame);
    }

    /**
     * Traite le passage de la fenetre de jeu
     * a la fenetre de menu
     */
    private void changeFromGameToMenu() {
        this.myController.resetModel();
        this.myPanelGame.setVisible(false);
        this.remove(this.myPanelGame);
        this.myPanelMenu.setVisible(true);
        this.add(this.myPanelMenu);
    }

    /**
     * Ouvre une boite de dialogue lorsque
     * l'un des joueurs a gagne
     */
    public void displayVictory() {
        if (myModel.getWinnerColor() != null) {
            if (myModel.getWinnerColor() == Color.BLUE)
                JOptionPane.showMessageDialog(null, "Le joueur bleu a gagné.");
            else if (myModel.getWinnerColor() == Color.RED)
                JOptionPane.showMessageDialog(null, "Le joueur rouge a gagné.");
        }
    }

    /**
     * Modifie View.myBackgroundImagePath
     * @param backgroundImagePath
     */
    public void setBackgroundImagePath(String backgroundImagePath) {
        this.myBackgroundImagePath = backgroundImagePath;
    }
}