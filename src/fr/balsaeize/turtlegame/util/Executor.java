package fr.balsaeize.turtlegame.util;

import java.io.IOException;

import fr.balsaeize.turtlegame.TurtleGame;

/**
 * Permet l'exécution de commande, par exemple pour nettoyer la console
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class Executor {

	/**
	 * Enumération permettant de lister les différentes commandes
	 * disponible à exécuter
	 * 
	 * @author Quentin CATHERINE et Axel ELAIN
	 * @version 1.0.0
	 */
	public enum Command {
		
		CLEAR_CONSOLE("cls", "clear");
		
		/** Commande a exécuter pour Windows **/
		private final String cmdWin;
		/** Commande a exéuter pour Unix (Mac, linux, etc...) **/
		private final String cmdUnix;
		
		/**
		 * Constructeur de l'énumération, il permet d'instancier les commandes disponibles
		 * 
		 * @param cmdWin La commande au format Windows
		 * @param cmdUnix La commande au format Unix
		 */
		private Command(String cmdWin, String cmdUnix)
		{			
			this.cmdWin  = cmdWin;
			this.cmdUnix = cmdUnix;
		}

		/**
		 * Permet de récupérer la commande à exécuter au format Windows
		 * 
		 * @return La commande au format Windows
		 */
		public String getCmdWin()
		{
			return cmdWin;
		}

		/**
		 * Permet de récupérer la commande à exécuter au format Unix
		 * 
		 * @return La commande au format Unix
		 */
		public String getCmdUnix()
		{
			return cmdUnix;
		}
		
		@Override
		public String toString()
		{
			return this.name() + " :: Win command: " + cmdWin + ", Unix command: " + cmdUnix;
 		}
		
	}
	
	/**
	 * Permet d'exécuter la commande et retourne l'état de l'exécution
	 * 
	 * @param cmd Commande a exécuté
	 * @see Command
	 * @return La commande a-t-elle été exécutée ?
	 */
	public static boolean executeCommand(Command cmd)
	{
		Process p = null; // Processus exécuté lors de l'exécution de la commande
		
		try
		{			
			if (TurtleGame.osName.contains("win")) // Si on est sous Windows
				p = Runtime.getRuntime().exec("cmd /C " + cmd.getCmdWin()); // alors on exécute le commande de Windows
			else
				p = Runtime.getRuntime().exec(cmd.getCmdUnix()); // Sinon, c'est celle pour Unix qui est exécutée
			
			ExecutorRunnable out = new ExecutorRunnable(p.getInputStream()); // On récupère les entrées
			ExecutorRunnable err = new ExecutorRunnable(p.getErrorStream()); // ON récupère les erreurs
			
			new Thread(out).start(); // On lance une Thread sur les entrées
			new Thread(err).start(); // On lance une Thread sur les erreurs
			
			p.waitFor(); // On attend que la commande s'exécute
			
			return true; // On retourne Vrai car la commande s'est bien exécutée
		}
		catch (IOException | InterruptedException e)
		{
			e.printStackTrace(); // On affiche l'erreur
			
			return false; // On retourne Faux car la commande à rencontré un problème
		}
	}
	
}
