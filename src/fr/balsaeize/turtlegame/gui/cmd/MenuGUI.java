package fr.balsaeize.turtlegame.gui.cmd;

import java.util.Scanner;

import fr.balsaeize.turtlegame.game.Game;
import fr.balsaeize.turtlegame.gui.InterfaceGUI;
import fr.balsaeize.turtlegame.util.Executor;
import fr.balsaeize.turtlegame.util.Executor.Command;
import fr.balsaeize.turtlegame.util.Util;

/**
 * Permet d'affichier l'interface les menus
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class MenuGUI implements InterfaceGUI {
	
	/** Tableau de tous les menus disponible **/
	private String[] menu;
	/** Jeu en cours **/
	private Game game;
	
	/**
	 * Permet de créer l'interface du menu
	 * 
	 * @param game Jeu
	 */
	public MenuGUI(Game game)
	{
		this.setGame(game);
	}

	@Override
	public void init()
	{
		menu = new String[2]; // Dans notre cas il y aura 2 menus
		
		// Un menu principal
		StringBuilder mainMenu = new StringBuilder();
		
		mainMenu.append("  ---------- MODE DE JEU ----------\n")
				.append("  1. Regarder l'ordinateur jouer   \n")
				.append("  2. Jouer au jeu                  \n")
				.append("  3. Quitter                       \n")
				.append("  ---------------------------------\n")
				.append("  >> ");
		
		StringBuilder pcMenu = new StringBuilder();
		
		// Un menu joueur
		pcMenu.append("  ------------------------- MODE JOUEUR -------------------------\n")
			  .append("  Combien de vrai joueur vont jouer ? (1 à 5) ");
		
		// On stocke les menus dans la tableau créé à cet effet
		menu[0] = mainMenu.toString();
		menu[1] = pcMenu.toString();
	}

	@Override
	public void render()
	{		
		Scanner sc  = new Scanner(System.in); // On se prépare à lire les entrées clacier
		String line = null; // La ligne pour stocker l'entrée clavier
		int option  = -1; // Le choix de l'utilisateur (1, 2, ou 3)
		
		do
		{
			mainMenu(menu[0]); // On affiche le menu principale
			
			line = sc.nextLine(); // On lit ce que l'utilisateur entre
			
			try
			{
				option = Integer.parseInt(line); // On regarde si la valeur entrée est un entier, sinon on lui dit
				
				// Parse de l'option
				switch (option)
				{
					// Case 1 on initialise le jeu
					case 1:
						game.initGame(0); // Initialisation du jeu
						
						line = null; //  On met la ligne à `null` pour ne pas avoir le menu qui s'affiche quand on joue
						
						return; // On sort
					// Case 2 on affiche le menu joueur
					case 2:
						playerMenu(menu[1]); // On affiche le menu joueur
						
						line = null; //  On met la ligne à `null` pour ne pas avoir le menu qui s'affiche quand on joue
						
						Executor.executeCommand(Command.CLEAR_CONSOLE); // On nettoie la console
						 
						return; // On sort
					// On quitte le jeu
					case 3:
						System.exit(0); // 
						break;
					// Par défaut, on affiche le menu principale
					default:
						mainMenu(menu[0]);
				}
			}
			catch (Exception e)
			{				
				System.out.println("  Vous devez préciser un chiffre."); // On informe l'utilisateur qu'on ne peut rentrer que des chiffres
				
				Util.sleep(1000); // On attend 1 seconde pour avoir le temps de lire le message
			}
		}
		while (line != null);
		
		sc.close();
	}
	
	/**
	 * Permet d'affichier le menu principal
	 * 
	 * @param menu Texte du menu princpal
	 */
	private void mainMenu(String menu)
	{
		Executor.executeCommand(Command.CLEAR_CONSOLE); // On nettoie le console
		
		System.out.print(menu); // On affiche le menu principal
	}
	
	/**
	 * Permet d'afficher le menu joueur
	 * 
	 * @param menu Texte du menu joueur
	 */
	@SuppressWarnings("resource")
	private void playerMenu(String menu)
	{
		Scanner sc   = new Scanner(System.in); // On initialise l'écoute clavier
		String line  = null; // On déclare la variable pour stocker les entrées clavier
		int nbPlayer = -1; // Permet de stocker le nombre de joueur à rentrer manuellement
		
		do
		{
			Executor.executeCommand(Command.CLEAR_CONSOLE); // On nettoie le console
			
			System.out.print(menu); // On affichhe le menu joueur
			
			line = sc.nextLine(); // On récupère l'entrée clavier
			
			try
			{
				nbPlayer = Integer.parseInt(line); // On regarde bien si la valeur entrée est un entier
				
				if (nbPlayer < 1 || nbPlayer > 5) // Si l'utilisateur ne rentre pas des valeurs en 1 et 5 comprit, on lui redemande
					continue;
				
				game.initGame(nbPlayer); // Sino on peut initialiser le jeu
				
				line = null; // Permet de ne plus boucler
			}
			catch (Exception e)
			{
				System.out.println("  Vous devez préciser un chiffre."); // On indique qu'on accepte que les chiffres
				
				Util.sleep(1000); // On attend 1 seconde pour avoir le temps de lire les messages
				
				Executor.executeCommand(Command.CLEAR_CONSOLE); // On nettoie le console
			}
		}
		while (line != null);
	}

	/**
	 * Permet de récupérer les menus
	 * 
	 * @return Les menues
	 */
	public String[] getMenu()
	{
		return menu;
	}

	/**
	 * Permet de modifier les menus
	 * 
	 * @param menu Nouveaux menus
	 */
	public void setMenu(String[] menu)
	{
		this.menu = menu;
	}

	/**
	 * Permet de récupérer le jeu
	 * 
	 * @return Le jeu
	 */
	public Game getGame()
	{
		return game;
	}

	/**
	 * Permet de de modifier le jeu
	 * 
	 * @param game Nouveau jeu
	 */
	public void setGame(Game game)
	{
		this.game = game;
	}

}
