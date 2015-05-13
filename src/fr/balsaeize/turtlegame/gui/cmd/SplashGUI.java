package fr.balsaeize.turtlegame.gui.cmd;

import fr.balsaeize.turtlegame.gui.InterfaceGUI;
import fr.balsaeize.turtlegame.util.Executor;
import fr.balsaeize.turtlegame.util.Executor.Command;
import fr.balsaeize.turtlegame.util.Util;

/**
 * Permet d'affichier le splash screen
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class SplashGUI implements InterfaceGUI {

	/** Texte du logo **/
	private StringBuilder logo;
	
	@Override
	public void init()
	{
		logo = new StringBuilder();
		
		logo.append(" ____        _           _____ _         \n")
			.append("| __ )  __ _| |___  __ _| ____(_)_______ \n")
			.append("|  _ \\ / _` | / __|/ _` |  _| | |_  / _ \\\n")
			.append("| |_) | (_| | \\__ \\ (_| | |___| |/ /  __/\n")
			.append("|____/ \\__,_|_|___/\\__,_|_____|_/___\\___|\n")
			.append("                           Entertainement");
	}

	@Override
	public void render()
	{
		System.out.println(logo.toString()); // On affiche le logo
		
		Util.sleep(1000); // On attend 1 seconde pour le voir
		
		Executor.executeCommand(Command.CLEAR_CONSOLE); // On nettoie le consoel
	}

	/**
	 * Permet de récupérer le logo
	 * 
	 * @return Le logo
	 */
	public StringBuilder getLogo()
	{
		return logo;
	}

	/**
	 * Permet de modifier le logo
	 * 
	 * @param logo Nouveau logo
	 */
	public void setLogo(StringBuilder logo)
	{
		this.logo = logo;
	}

}
