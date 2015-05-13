package fr.balsaeize.turtlegame.gui.cmd;

import fr.balsaeize.turtlegame.game.Game;
import fr.balsaeize.turtlegame.game.Player;
import fr.balsaeize.turtlegame.game.card.Card;
import fr.balsaeize.turtlegame.game.card.ProgressCard;
import fr.balsaeize.turtlegame.gui.InterfaceGUI;
import fr.balsaeize.turtlegame.util.Color;
import fr.balsaeize.turtlegame.util.Executor;
import fr.balsaeize.turtlegame.util.Executor.Command;

/**
 * Permet d'affichier l'interface homme/machine de la partie en cours sous format console
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class GameGUI implements InterfaceGUI {
	
	/**	GUI du jeu **/
	private StringBuilder gui;
	/** Le moteur du jeu cf. Game.java **/
	private Game game;
	
	/**
	 * Permet d'instancier une nouvelle interface graphique du jeu
	 * 
	 * @param game Jeu
	 */
	public GameGUI(Game game)
	{		
		this.game = game;
	}

	@Override
	public void init()
	{
		
	}
	
	@Override
	public void render()
	{
		Executor.executeCommand(Command.CLEAR_CONSOLE); // On nettoie la console
		
		// On liste tous les joueurs
		for (Player p : game.getPlayers())
		{
			// Si le joueur est le joueur courant, on le marque en l'entourant de crochet
			if (p.equals(game.getCurrentPlayer()))
				System.out.print(" [" + p.getName() + "] ");
			// Sinon on affiche juste son prénom
			else
				System.out.print("  " + p.getName() + "  ");
		}
		
		System.out.println("\n\n");
		
		// On affiche les 5 lignes pour les 5 tortues
		// Chaque ligne de tortue est constituée de 3 lignes
		for (int i = 0; i < 5; i++)
		{
			StringBuilder line1 = new StringBuilder(); // Première ligne pour une tortue
			StringBuilder line2 = new StringBuilder(); // Deuxième ligne pour une tortue
			StringBuilder line3 = new StringBuilder(); // Troisième ligne pour une tortie
			
			line1.append("G |"); //
			line2.append("O |"); // Petit message permettant de marquer le début
			line3.append("! |"); //
			
			// On parcours toutes la case pour trouver les tortues
			for (int j = 0; j < 10; j++)
			{
				// Si on trouve une tortue
				if (game.getPlatform().get(i).get(j) != null)
				{
					// On l'affichie avec ses couleurs
					line1.append(new Color(game.getPlatform().get(i).get(j).getColor(), true).getColorCode()).append("  .-./*)").append(Color.reset());
					line2.append(new Color(game.getPlatform().get(i).get(j).getColor(), true).getColorCode()).append("_/___\\/ ").append(Color.reset());
					line3.append(new Color(game.getPlatform().get(i).get(j).getColor(), true).getColorCode()).append("  U U   ").append(Color.reset());
				}
				// Sinon
				else
				{
					// On affiche pas la tortue
					line1.append("        ");
					line2.append("--------");
					line3.append("        ");
				}
			}
			
			line1.append("| E"); //
			line2.append("| N"); // Petit message permettant de marquer la fin
			line3.append("| D"); //
			
			System.out.println();
			System.out.println(line1.toString()); //
			System.out.println(line2.toString()); // On affiche la ligne de la tortue
			System.out.println(line3.toString()); //
		}
		
		// On affiche les cartes du joueur
		System.out.print("\n  >> Les cartes de " + game.getCurrentPlayer().getName() + ": ");
		
		// On parcours toutes les cartes du joueur et on les affiche avec les couleurs associées
		for (Card c : game.getCurrentPlayer().getCards())
			System.out.print(new Color(c.getColor(), true).getColorCode() + "[" + ((ProgressCard)c).getType().getSchema() + "]" + Color.reset() + " ");
		
		System.out.println();
	}

	public StringBuilder getGui()
	{
		return gui;
	}

	public void setGui(StringBuilder gui)
	{
		this.gui = gui;
	}

	public Game getGame()
	{
		return game;
	}

	public void setGame(Game game)
	{
		this.game = game;
	}

}
