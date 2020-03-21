/**
 * @author RIOU PUYOOU S3C
 */
package View;

import java.awt.*;

import javax.swing.*;

import Model.Cell;
import Model.Model;

@SuppressWarnings("serial")
public class PanelGame extends JPanel {

    /**
     * Modele de jeu
     */
    private Model myModel;
    /**
     * Bouton de menu
     */
    private JButton myMenuButton;

    private JLabel myPlayerTurn;
    private Image myBackgroundImage;

    /**
     * Constructeur
     * @param model
     */
    public PanelGame(Model model) {
        this.myModel = model;
        this.setLayout(null);
        this.myMenuButton = new JButton("Menu");
        this.myPlayerTurn = new JLabel("Joueur :");
        this.myPlayerTurn.setForeground(Color.WHITE);
        this.myPlayerTurn.setBounds(700,10,100,100);
        this.myMenuButton.setBounds(250,20,100,50);
        this.add(myPlayerTurn);
        this.add(myMenuButton);
    }

    /**
     * Remplace le modele existant par le
     * modele mis en parametre
     * @param model
     */
    public void setModel(Model model) {
        this.myModel = model;
    }

    /**
     * Dessine les hexagones et l'image de fond
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.myBackgroundImage,0,0,800,600,null);
        Cell cellCurrentPlayer = new Cell(-1,-1,700,70,this.myModel.getPlayer().play(),this.myModel.getGameBoard().getCellDiameter()/2);
        g.setColor(cellCurrentPlayer.getColor());
        g.drawPolygon(cellCurrentPlayer);
        g.fillPolygon(cellCurrentPlayer);
        for (Cell c : this.myModel.getGameBoard().getCellCollection()) {
            if( c != null) {
                // On dessine le haut
                if (c.getGameBoardY() == 0) {
                    g.setColor(Color.BLUE);
                    g.fillPolygon(c.getCellsBorder(this.myModel.getNbLines(), this.myModel.getNbColumns(), 3, 3));

                    if ( c.getGameBoardX() == this.myModel.getNbColumns() -1){

                        g.setColor(Color.RED);
                        g.fillPolygon(c.getCellsBorder(this.myModel.getNbLines(), this.myModel.getNbColumns(), 5, 3));
                    }
                    else if (c.getGameBoardX() == 0){
                        g.setColor(Color.BLACK);
                        g.fillPolygon(c.getCellsBorder(this.myModel.getNbLines(), this.myModel.getNbColumns(), 3, 2));
                        g.setColor(Color.RED);
                        g.fillPolygon(c.getCellsBorder(this.myModel.getNbLines(), this.myModel.getNbColumns(), 2, 2));
                    }

                }
                // On dessine le bas
                else if (c.getGameBoardY() == this.myModel.getNbLines()-1) {
                    g.setColor(Color.BLUE);
                    g.fillPolygon(c.getCellsBorder(this.myModel.getNbLines(), this.myModel.getNbColumns(), 0, 3));

                    if ( c.getGameBoardX() == 0){
                        g.setColor(Color.RED);
                        g.fillPolygon(c.getCellsBorder(this.myModel.getNbLines(), this.myModel.getNbColumns(), 2, 3));
                    }
                    else if (c.getGameBoardX() == this.myModel.getNbColumns()-1){
                        g.setColor(Color.BLACK);
                        g.fillPolygon(c.getCellsBorder(this.myModel.getNbLines(), this.myModel.getNbColumns(), 0, 2));
                        g.setColor(Color.RED);
                        g.fillPolygon(c.getCellsBorder(this.myModel.getNbLines(), this.myModel.getNbColumns(), 5, 2));
                    }
                }

                //On dessine le cote gauche
                else if (c.getGameBoardX() == 0) {
                    g.setColor(Color.RED);
                    g.fillPolygon(c.getCellsBorder(this.myModel.getNbLines(), this.myModel.getNbColumns(), 2, 3));
                }

                // On dessine le cote droit
                else if (c.getGameBoardX() == this.myModel.getNbColumns()-1) {
                    g.setColor(Color.RED);
                    g.fillPolygon(c.getCellsBorder(this.myModel.getNbLines(), this.myModel.getNbColumns(), 5, 3));
                }
                g.setColor(c.getColor());
                g.fillPolygon(c);
                g.setColor(Color.BLACK);
                g.drawPolygon(c);
            }
        }

    }

    /**
     * @return this.myMenuButton
     */
    public JButton getMenuButton() {
        return this.myMenuButton;
    }

    /**
     * Ajoute une image en fonction du chemin donné en parametre
     */
    public void addBackgroundImage(String backgroundImagePath) {
        ImageIcon imageIcon = new ImageIcon(backgroundImagePath);
        this.myBackgroundImage = imageIcon.getImage();
    }


}
