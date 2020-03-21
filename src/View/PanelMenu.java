/**
 * @author RIOU PUYOOU S3C
 */
package View;

import Model.Model;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

@SuppressWarnings("serial")
public class PanelMenu extends JPanel {

    /**
     * Image de fond
     */
    private Image myBackgroundImage;
    /**
     * Bouton Jouer
     */
    private JButton myButtonPlay = new JButton("Jouer");

    /**
     * Bouton Quitter
     */
    private JButton myButtonQuit = new JButton("Quitter");

    /**
     * Bouton a cocher Espace
     */
    private JRadioButton myJRadioButtonSpace;

    /**
     * Bouton a cocher Nature
     */
    private JRadioButton myJRadioButtonNature;

    /**
     * Bouton a cocher Plage
     */
    private JRadioButton myJRadioButtonBeach;

    /**
     * Bouton a cocher Ville
     */
    private JRadioButton myJRadioButtonCity;

    /**
     * Bouton a cocher Default
     */
    private JRadioButton myJRadioButtonDefault;

    /**
     * Bouton qui a ete selectionne avant.
     * Est egal a View.JRadioButtonDefault
     * si aucun bouton n'est selectionne sur le Menu
     */
    private JRadioButton myPreviousJRadioButtonSelected;

    /**
     * Titre en haut de la fenetre
     */
    private JLabel myTitle = new JLabel("HEX");

    /**
     * Fonte de View.myTitle et des Boutons Jouer et Quitter
     */
    private Font myFont;

    public PanelMenu() {

        super();
        this.setSize(800, 600);
        this.setLayout(null);
        this.myTitle.setBounds(170, 0, 500, 320);
        setButtonsBounds();
        initFont();
        initCheckBoxThemes();
        addItems();
    }

    /**
     * Place les boutons sur la fenetre
     */
    public void setButtonsBounds() {
        this.myButtonPlay.setBounds(262, 400, 100, 50);
        this.myButtonQuit.setBounds(437, 400, 100, 50);
    }

    /**
     * Initialise View.myFont et modifie la police des
     * boutons et du titre
     */
    public void initFont() {
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/font.ttf"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        this.myFont = myFont.deriveFont(10.0f);
        this.myButtonPlay.setFont(myFont);
        this.myButtonQuit.setFont(myFont);
        this.myFont = this.myFont.deriveFont(150.0f);
        this.myTitle.setForeground(Color.WHITE);
        this.myTitle.setFont(myFont);
    }

    /**
     * Ajoute des elements sur le Panel
     */
    public void addItems() {
        this.add(myButtonPlay);
        this.add(myButtonQuit);
        this.add(myTitle);
        this.addRadioButtons();
    }

    /**
     * Initialise les JRadioButton
     */
    private void initCheckBoxThemes() {
        this.instantiateRadioButtons();
        this.myJRadioButtonDefault.setSelected(true);
        this.setRadioButtonsBounds();
        this.addRadioButtons();
    }

    /**
     * Creation des JRadioButtons
     */
    public void instantiateRadioButtons() {
        this.myJRadioButtonSpace = new JRadioButton("Espace");
        this.myJRadioButtonNature = new JRadioButton("Nature");
        this.myJRadioButtonBeach = new JRadioButton("Plage");
        this.myJRadioButtonCity = new JRadioButton("Ville");
        this.myJRadioButtonDefault = new JRadioButton("Defaut");
    }

    /**
     * Ajout sur la fenetre
     */
    public void addRadioButtons() {
        this.add(this.myJRadioButtonSpace);
        this.add(this.myJRadioButtonNature);
        this.add(this.myJRadioButtonBeach);
        this.add(this.myJRadioButtonCity);
        this.add(this.myJRadioButtonDefault);
    }

    /**
     * Placement des boutons
     */
    public void setRadioButtonsBounds() {
        this.myJRadioButtonSpace.setBounds(212, 325, 75, 50);
        this.myJRadioButtonNature.setBounds(287, 325, 75, 50);
        this.myJRadioButtonBeach.setBounds(362, 325, 75, 50);
        this.myJRadioButtonCity.setBounds(437, 325, 75, 50);
        this.myJRadioButtonDefault.setBounds(512, 325, 75, 50);
    }

    /**
     * @return PanelMenu.myButtonPlay
     */
    public JButton getButtonPlay() {
        return this.myButtonPlay;
    }

    /**
     * @return PanelMenu.myButtonQuit
     */
    public JButton getButtonQuit() {
        return this.myButtonQuit;
    }

    /**
     * Modifie l'image du fond de Panel
     * en fonciton de la chaine de caracteres
     * mise en parametre
     * @param backgroundImagePath
     */
    public void addBackgroundImage(String backgroundImagePath) {
        ImageIcon imageIcon = new ImageIcon(backgroundImagePath);
        this.myBackgroundImage = imageIcon.getImage();
        this.checkCheckboxSelected();
    }

    /**
     * Verifie et modifie les boutons selectionnes
     * afin de ne pouvoir en avoir qu'un seul de
     * selectionne a la fois
     */
    public void checkCheckboxSelected() {
        if (buttonSpaceAlreadySelected()) {
            this.myPreviousJRadioButtonSelected = this.myJRadioButtonSpace;
            this.setNotSpaceButtonsFalse();
        }
        if (buttonNatureAlreadySelected()) {
            this.myPreviousJRadioButtonSelected = this.myJRadioButtonNature;
            this.setNotNatureButtonsFalse();
        }
        if (buttonBeachAlreadySelected()) {
            this.myPreviousJRadioButtonSelected = this.myJRadioButtonBeach;
            this.setNotBeachButtonsFalse();
        }
        if (buttonCityAlreadySelected()) {
            this.myPreviousJRadioButtonSelected = this.myJRadioButtonCity;
            this.setNotCityButtonsFalse();
        }
        if (buttonDefaultAlreadySelected()) {
            this.myPreviousJRadioButtonSelected = this.myJRadioButtonDefault;
            this.setNotDefaultButtonFalse();
        }

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.myBackgroundImage,0,0,800,600,null);
    }

    /**
     * @return PanelMenu.myJRadioButtonDefault.isSelected()
    && PanelMenu.myJRadioButtonDefault != PanelMenu.myPreviousJRadioButtonSelected
     */
    public boolean buttonDefaultAlreadySelected() {
        return this.myJRadioButtonDefault.isSelected()
                && this.myJRadioButtonDefault != this.myPreviousJRadioButtonSelected;
    }

    /**
     * @return PanelMenu.myJRadioButtonCity.isSelected()
    && PanelMenu.myJRadioButtonCity != PanelMenu.myPreviousJRadioButtonSelected
     */
    public boolean buttonCityAlreadySelected() {
        return this.myJRadioButtonCity.isSelected() && this.myJRadioButtonCity != this.myPreviousJRadioButtonSelected;
    }

    /**
     * @return PanelMenu.myJRadioButtonBeach.isSelected()
    && PanelMenu.myJRadioButtonBeach != PanelMenu.myPreviousJRadioButtonSelected
     */
    public boolean buttonBeachAlreadySelected() {
        return this.myJRadioButtonBeach.isSelected() && this.myJRadioButtonBeach != this.myPreviousJRadioButtonSelected;
    }

    /**
     * @return PanelMenu.myJRadioButtonNature.isSelected()
    && PanelMenu.myJRadioButtonNature != PanelMenu.myPreviousJRadioButtonSelected
     */
    public boolean buttonNatureAlreadySelected() {
        return this.myJRadioButtonNature.isSelected()
                && this.myJRadioButtonNature != this.myPreviousJRadioButtonSelected;
    }

    /**
     * @return PanelMenu.myJRadioButtonSpace.isSelected()
    && PanelMenu.myJRadioButtonSpace != PanelMenu.myPreviousJRadioButtonSelected
     */
    public boolean buttonSpaceAlreadySelected() {
        return this.myJRadioButtonSpace.isSelected()
                && this.myJRadioButtonSpace != this.myPreviousJRadioButtonSelected;
    }

    /**
     * @return PanelMenu.myJRadioButtonSpace
     */
    public JRadioButton getMyJRadioButtonEspace() {
        return this.myJRadioButtonSpace;
    }

    /**
     * @return PanelMenu.myJRadioButtonNature
     */
    public JRadioButton getMyJRadioButtonNature() {
        return this.myJRadioButtonNature;
    }

    /**
     * @return PanelMenu.myJRadioButtonBeach
     */
    public JRadioButton getMyJRadioButtonPlage() {
        return this.myJRadioButtonBeach;
    }

    /**
     * @return PanelMenu.myJRadioButtonCity
     */
    public JRadioButton getMyJRadioButtonVille() {
        return this.myJRadioButtonCity;
    }

    /**
     * @return PanelMenu.myJRadioButtonDefault
     */
    public JRadioButton getMyJRadioButtonDefaut() {
        return this.myJRadioButtonDefault;
    }


    /**
     * Modifie tous les boutons autres que le
     * bouton Default non selectionne
     */
    public void setNotDefaultButtonFalse() {
        this.myJRadioButtonNature.setSelected(false);
        this.myJRadioButtonBeach.setSelected(false);
        this.myJRadioButtonCity.setSelected(false);
        this.myJRadioButtonSpace.setSelected(false);
    }

    /**
     * Modifie tous les boutons autres que le
     * bouton City non selectionne
     */
    public void setNotCityButtonsFalse() {
        this.myJRadioButtonNature.setSelected(false);
        this.myJRadioButtonBeach.setSelected(false);
        this.myJRadioButtonSpace.setSelected(false);
        this.myJRadioButtonDefault.setSelected(false);
    }

    /**
     * Modifie tous les boutons autres que le
     * bouton Beach non selectionne
     */
    public void setNotBeachButtonsFalse() {
        this.myJRadioButtonNature.setSelected(false);
        this.myJRadioButtonSpace.setSelected(false);
        this.myJRadioButtonCity.setSelected(false);
        this.myJRadioButtonDefault.setSelected(false);
    }

    /**
     * Modifie tous les boutons autres que le
     * bouton Nature non selectionne
     */
    public void setNotNatureButtonsFalse() {
        this.myJRadioButtonSpace.setSelected(false);
        this.myJRadioButtonBeach.setSelected(false);
        this.myJRadioButtonCity.setSelected(false);
        this.myJRadioButtonDefault.setSelected(false);
    }

    /**
     * Modifie tous les boutons autres que le
     * bouton Space non selectionne
     */
    public void setNotSpaceButtonsFalse() {
        this.myJRadioButtonNature.setSelected(false);
        this.myJRadioButtonBeach.setSelected(false);
        this.myJRadioButtonCity.setSelected(false);
        this.myJRadioButtonDefault.setSelected(false);
    }

}
