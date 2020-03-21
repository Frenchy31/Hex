/**
 * @author RIOU PUYOOU S3C
 */
package View;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import Controller.Controller;


/**
 * Classe Click qui permet de récupérer les clicks sur l'écran
 */
public class Click extends MouseInputAdapter{

	private Controller myController;

	/**
	 * Constructeur : ajoute un controller
	 * @param controller
	 */
	public Click(Controller controller){
		super();
		this.myController = controller;
	}

	/**
	 * Gère le click d'une souris
	 * @param e
	 */
	@Override
	public void mouseClicked(MouseEvent e){
		super.mouseClicked(e);
	}

	/**
	 * Gère le relachement du click de la souris
	 * Appelle la fonction colorize() du Controller
	 * @param e
	 */
	@Override
	public void mouseReleased(MouseEvent e){
		super.mouseReleased(e);
		this.myController.colorize(e.getPoint());
	}

}
