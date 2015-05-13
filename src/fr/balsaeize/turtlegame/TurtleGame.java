package fr.balsaeize.turtlegame;

import fr.balsaeize.turtlegame.game.Game;
import fr.balsaeize.turtlegame.gui.cmd.MenuGUI;

/**
 * Classe principale du jeu, c'est ici que se trouve la m�thode principale
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class TurtleGame {
	
	/** Nom du syst�me d'exploitation **/
	public static String osName;
	
	/**
	 * Constructeur du jeu
	 */
	public TurtleGame()
	{
		osName = System.getProperty("os.name").toLowerCase(); // On récupère le système d'exploitation
		
		MenuGUI menu = new MenuGUI(new Game()); // On instancie le menu
		
		menu.init(); // On initialise le menu
		menu.render(); // On affiche le menu
	}

	/**
	 * Méthode principale du jeu
	 * 
	 * @param args Arguments passés en paramètre à l'exécution du jeu
	 */
	public static void main(String[] args)
	{				
		/** TODO: Ajouter `equals` et `toString` **/
		
		new TurtleGame(); // On lance un nouveau jeu
	}

}
