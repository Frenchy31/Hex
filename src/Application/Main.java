/**
 * @author RIOU PUYOOU S3C
 */
package Application;

import Controller.Controller;
import Model.Model;
import View.View;

public class Main {

	/**
	 * Lancement du programme
	 * @param args
	 */
	public static void main(String[] args) {
		Model model = new Model();
		Controller controller = new Controller(model);
		@SuppressWarnings("unused")
		View view = new View(model, controller);

	}
}
