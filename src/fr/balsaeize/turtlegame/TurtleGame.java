package fr.balsaeize.turtlegame;

import fr.balsaeize.turtlegame.gui.cmd.SplashGUI;
import fr.balsaeize.turtlegame.util.Executor;
import fr.balsaeize.turtlegame.util.Executor.Command;

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
		osName = System.getProperty("os.name").toLowerCase();
		
		SplashGUI splash = new SplashGUI();
		
		splash.init();
		splash.render();
	}

	/**
	 * M�thode principale du jeu
	 * 
	 * @param args Arguments pass�s en param�tre � l'ex�cution du jeu
	 */
	public static void main(String[] args)
	{				
		/** TODO: Ajouter `equals` et `toString` **/
		
		new TurtleGame();
	}

}
